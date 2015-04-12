package net.shangtech.eshop.manager.spider.alibaba;

import java.util.LinkedList;
import java.util.List;

import net.shangtech.eshop.manager.spider.suport.ProductWrapper;
import net.shangtech.eshop.product.entity.Sku;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.HasParentFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.ImageTag;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeIterator;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

public class ProductListParser {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductListParser.class);
	
	private String url;
	
	public ProductListParser(String url){
		this.url = url;
	}
	
	public List<ProductWrapper> parse() throws ParserException{
		List<ProductWrapper> list = new LinkedList<ProductWrapper>();
		if(!url.startsWith("http://")){
			url = "http://www.winsmoke.com" + url;
		}
		Parser parser = new Parser();
		parser.setURL(url);
		logger.info("parsing url {}", url);
		NodeFilter pFilter = new HasParentFilter(new HasAttributeFilter("class", "product-img savm"));
		NodeFilter aFilter = new TagNameFilter("a");
		NodeFilter filter = new AndFilter(pFilter, aFilter);
		NodeList nodes = parser.extractAllNodesThatMatch(filter);
		NodeIterator it = nodes.elements();
		while(it.hasMoreNodes()){
			LinkTag link = (LinkTag) it.nextNode();
			ProductWrapper wrapper = new ProductWrapper();
			Sku sku = new Sku();
			wrapper.setProduct(sku);
			wrapper.setUrl(link.extractLink());
			logger.info("json:{}", "{" + link.getAttribute("data-domdot") + "}");
			JSONObject jsonObject = JSONObject.parseObject("{" + link.getAttribute("data-domdot") + "}");
			sku.setCode(jsonObject.getString("pid"));
			sku.setImage(((ImageTag)link.childAt(1)).getAttribute("data-src"));
			sku.setName(((LinkTag)link.getParent().getNextSibling().getNextSibling().getChildren().elementAt(1)).getAttribute("title"));
			list.add(wrapper);
		}
		return list;
	}
}
