package net.shangtech.eshop.manager.spider.alibaba;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.shangtech.eshop.manager.spider.suport.CategoryWrapper;
import net.shangtech.eshop.manager.spider.suport.ProductWrapper;
import net.shangtech.eshop.product.entity.Category;
import net.shangtech.eshop.product.entity.Sku;
import net.shangtech.eshop.product.service.CategoryService;
import net.shangtech.eshop.product.service.SkuService;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.Bullet;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeIterator;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public class AliSpider {
	
	private static final Logger logger = LoggerFactory.getLogger(AliSpider.class);
	
	@Autowired private CategoryService categoryService;
	@Autowired private SkuService skuService;
	
	private static final String FACT_URL = "http://www.winsmoke.com/productlist.html";
	public void parseCategories() throws ParserException{
		//解析产品分类
		List<CategoryWrapper> categoryWrappers = parseCategory();
		for(CategoryWrapper categoryWrapper : categoryWrappers){
			logger.info("category {}, has {} children", categoryWrapper.getCategory().getCode(), categoryWrapper.getChildren().size());
			Category parent = categoryWrapper.getCategory();
			parent.setLeaf(CollectionUtils.isEmpty(categoryWrapper.getChildren()));
			categoryService.save(parent);
			categoryWrapper.setId(parent.getId());
			for(CategoryWrapper childWrapper : categoryWrapper.getChildren()){
				Category child = childWrapper.getCategory();
				child.setLeaf(true);
				child.setParentId(parent.getId());
				categoryService.save(child);
				childWrapper.setId(child.getId());
			}
		}
	}
	
	private List<CategoryWrapper> parseCategory() throws ParserException{
		List<CategoryWrapper> list = new ArrayList<CategoryWrapper>();
		Parser parser = new Parser();
		parser.setURL(FACT_URL);
		NodeFilter filter = new HasAttributeFilter("class", "productgroup-list");
		NodeList nodeList = parser.extractAllNodesThatMatch(filter);
		NodeList productGroupList = nodeList.elementAt(0).getChildren();
		NodeIterator productGroupListIterator = productGroupList.elements();
		while(productGroupListIterator.hasMoreNodes()){
			Node productGroupNode = productGroupListIterator.nextNode();
			if(!(productGroupNode instanceof Bullet)){
				continue;
			}
			Parser productGroupParser = new Parser();
			productGroupParser.setInputHTML(productGroupNode.toHtml());
			NodeFilter productGroupFilter = new TagNameFilter("a");
			NodeList nodes = productGroupParser.extractAllNodesThatMatch(productGroupFilter);
			CategoryWrapper wrapper = parseCategoryWrapper(nodes.elementAt(0));
			wrapper.setChildren(new ArrayList<CategoryWrapper>());
			for(int i = 1; i < nodes.size(); i++){
				CategoryWrapper child = parseCategoryWrapper(nodes.elementAt(i));
				wrapper.getChildren().add(child);
			}
			list.add(wrapper);
		}
		return list;
	}
	
	private CategoryWrapper parseCategoryWrapper(Node node){
		LinkTag link = (LinkTag) node;
		CategoryWrapper wrapper = new CategoryWrapper();
		String url = link.extractLink();
		String code = url.substring(url.lastIndexOf("/") + 1, url.lastIndexOf("."));
		String name = code;
		wrapper.setUrl(url);
		Category category = new Category();
		category.setCode(code);
		category.setUrl(url);
		category.setCreateTime(new Date());
		category.setName(name);
		category.setVersion(new Date());
		wrapper.setCategory(category);
		logger.info("find category {}", category.getCode());
		return wrapper;
	}
	
	public void parseProducts() throws ParserException{
		List<Category> categories = categoryService.findAll();
		for(Category category : categories){
			logger.info("processing category {}, url={}", category.getId(), category.getUrl());
			List<ProductWrapper> productWrappers = new ProductListParser(category.getUrl()).parse();
			logger.info("find {} products", productWrappers.size());
			for(ProductWrapper wrapper : productWrappers){
				logger.info("processing product {}", wrapper.getProduct().getCode());
				Sku old = skuService.findByCode(wrapper.getProduct().getCode());
				if(old != null){
					logger.info("product {} exists", wrapper.getProduct().getCode());
					continue;
				}
				Sku sku = wrapper.getProduct();
				Parser imageParser = new Parser();
				imageParser.setURL(wrapper.getUrl());
				NodeFilter imageFilter = new HasAttributeFilter("class", "inav util-clearfix");
				NodeList imageUl = imageParser.extractAllNodesThatMatch(imageFilter);
				if(imageUl == null || imageUl.size() == 0){
					sku.setImageNum(0);
				}else{
					sku.setImageNum(imageUl.elementAt(0).getChildren().size());
				}
				Parser detailParser = new Parser();
				detailParser.setURL(wrapper.getUrl());
				NodeFilter detailFilter = new HasAttributeFilter("class", "detail-content ui-tab-pane ui-tab-active");
				NodeList detailNodeList = detailParser.extractAllNodesThatMatch(detailFilter);
				sku.setContent(detailNodeList.elementAt(0).toHtml());
				sku.setCategoryId(category.getId());
				logger.info("save sku {}", sku.getCode());
				skuService.save(sku);
			}
		}
	}
}
