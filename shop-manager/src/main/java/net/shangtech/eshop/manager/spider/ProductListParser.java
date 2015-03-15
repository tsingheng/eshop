package net.shangtech.eshop.manager.spider;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import net.shangtech.eshop.manager.spider.suport.ProductWrapper;
import net.shangtech.eshop.product.entity.Sku;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.ClientProtocolException;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.Div;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.tags.ScriptTag;
import org.htmlparser.util.NodeIterator;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class ProductListParser {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductListParser.class);
	
	private static final String HOST = "http://category.vip.com";
	
	private String url;
	
	private String html;
	
	private List<ProductWrapper> list;
	
	public ProductListParser(String url){
		this.url = url;
	}
	
	public void init() throws ParserException, InterruptedException{
		list = new LinkedList<ProductWrapper>();
		logger.info("parsing {}", url);
		Parser parser = new Parser();
		parser.setURL(url);
//		Thread.sleep(2000);
		NodeFilter filter = new TagNameFilter("body");
		NodeList nodes = parser.extractAllNodesThatMatch(filter);
		html = nodes.elementAt(0).toHtml().replaceAll("figure|figcaption", "div");
	}
	
	public List<ProductWrapper> parse() throws ParserException, ClientProtocolException, IOException, InterruptedException{
		
		parseNextPageUrl();
		
		parseHtml();
		parseJs();
		
		logger.info("find {} products", list.size());
		
		return list;
	}
	
	private void parseHtml() throws ParserException{
		Parser parser = new Parser();
		parser.setInputHTML(html);
		NodeFilter filter = new HasAttributeFilter("class", "cat-list-item  J_cat_list_item");
		NodeList nodes = parser.extractAllNodesThatMatch(filter);
		if(nodes != null){
			NodeIterator it = nodes.elements();
			while(it.hasMoreNodes()){
				Node node = it.nextNode();
				if(node instanceof Div){
					Div div = (Div) node;
					ProductWrapper wrapper = new ProductWrapper();
					Sku product = new Sku();
					String id = div.getAttribute("id");
					product.setVid(id.replace("J_pro_", ""));
					wrapper.setProduct(product);
					list.add(wrapper);
					parseProductColors(wrapper.getDetailUrl());
				}
			}
		}
	}
	
	private void parseJs() throws ParserException{
		Parser parser = new Parser();
		parser.setInputHTML(html);
		NodeFilter filter = new TagNameFilter("script");
		NodeList nodes = parser.extractAllNodesThatMatch(filter);
		if(nodes != null){
			for(int i = 0; i < nodes.size(); i++){
				ScriptTag script = (ScriptTag) nodes.elementAt(i);
				String content = script.getScriptCode();
				if(content.contains("allData")){
					content = content.substring(content.indexOf("data"));
					content = content.substring(content.indexOf("[{"), content.indexOf("}]")+2);
					JSONArray array = JSONArray.parseArray(content);
					for(Object item : array){
						JSONObject obj = (JSONObject) item;
						Sku product = new Sku();
						product.setVid(obj.getString("id"));
						
						ProductWrapper wrapper = new ProductWrapper();
						wrapper.setProduct(product);
						list.add(wrapper);
						parseProductColors(wrapper.getDetailUrl());
					}
				}
			}
		}
	}
	
	public void parseNextPageUrl() throws ParserException, InterruptedException{
		init();
		String prev = this.url;
		this.url = null;
		Parser parser = new Parser();
		parser.setInputHTML(html);
		NodeFilter filter = new HasAttributeFilter("class", "cat-paging-next");
		NodeList nodes = parser.extractAllNodesThatMatch(filter);
		if(nodes != null && nodes.size() > 0){
			Node node = nodes.elementAt(0);
			if(node instanceof LinkTag){
				url = ((LinkTag) node).getLink();
				if(StringUtils.isNotBlank(url) && !url.startsWith("http://")){
					url = HOST + url;
				}
			}
		}
		if(StringUtils.equalsIgnoreCase(prev, url)){
			this.url = null;
		}
		logger.info("next page is {}", url);
	}
	
	
	/**
	 * 解析同款商品其他颜色
	 * @param wrapper
	 * @throws ParserException
	 */
	private void parseProductColors(String url) throws ParserException{
		Parser parser = new Parser();
		parser.setURL(url);
		NodeFilter filter = new HasAttributeFilter("class", "color-list-item");
		NodeList nodes = parser.extractAllNodesThatMatch(filter);
		if(nodes != null){
			NodeIterator it = nodes.elements();
			while(it.hasMoreNodes()){
				NodeList colors = it.nextNode().getChildren();
				if(colors != null){
					NodeIterator colorIterator = colors.elements();
					while(colorIterator.hasMoreNodes()){
						Node color = colorIterator.nextNode();
						if(color instanceof LinkTag){
							LinkTag link = (LinkTag) color;
							if(!StringUtils.contains(link.getAttribute("class"), "selected")){
								Sku product = new Sku();
								String id = link.getAttribute("id");
								product.setVid(id.replace("J-colorItem-", ""));
								ProductWrapper wrapper = new ProductWrapper();
								wrapper.setProduct(product);
								list.add(wrapper);
								logger.info("find another color {}", product.getVid());
							}
						}
					}
				}
			}
		}
	}
	
	public boolean hasMore(){
		return StringUtils.isNotBlank(url);
	}

	public String getUrl() {
		return url;
	}
	
}
