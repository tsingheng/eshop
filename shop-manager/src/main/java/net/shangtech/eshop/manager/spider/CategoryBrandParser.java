package net.shangtech.eshop.manager.spider;

import java.util.LinkedList;
import java.util.List;

import net.shangtech.eshop.manager.spider.suport.CategoryBrandWrapper;
import net.shangtech.eshop.product.entity.Brand;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.tags.CompositeTag;
import org.htmlparser.tags.ImageTag;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeIterator;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CategoryBrandParser {
	
	private static final Logger logger = LoggerFactory.getLogger(CategoryBrandParser.class);
	
	/** 分类url */
	private String url;
	
	public CategoryBrandParser(String url){
		this.url = url;
	}
	
	public List<CategoryBrandWrapper> parse() throws ParserException{
		List<CategoryBrandWrapper> list = new LinkedList<CategoryBrandWrapper>();
		Parser parser = new Parser();
		parser.setURL(url);
		NodeFilter filter = new HasAttributeFilter("mars_sead", "te_onsale_filterlist_brand_img");
		NodeList nodes = parser.extractAllNodesThatMatch(filter);
		if(nodes != null){
			NodeIterator it = nodes.elements();
			while(it.hasMoreNodes()){
				Node node = it.nextNode();
				if(node instanceof LinkTag){
					LinkTag link = (LinkTag) node;
					CategoryBrandWrapper wrapper = new CategoryBrandWrapper();
					Brand brand = new Brand();
					brand.setSn(link.getAttribute("data-id"));
					brand.setName(link.getAttribute("title"));
					ImageTag image = ((ImageTag) ((CompositeTag) node).childAt(1));
					brand.setLogo(image.getImageURL());
					wrapper.setBrand(brand);
					wrapper.setUrl(link.getLink());
					list.add(wrapper);
				}
			}
		}
		logger.info("find {} brands in {}", list.size(), url);
		return list;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
