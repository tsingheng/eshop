package net.shangtech.eshop.manager.spider;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import net.shangtech.eshop.manager.spider.suport.ProductWrapper;
import net.shangtech.eshop.product.entity.Inventory;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.nodes.TextNode;
import org.htmlparser.tags.CompositeTag;
import org.htmlparser.tags.ImageTag;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.tags.ParagraphTag;
import org.htmlparser.util.NodeIterator;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


/**
 * 只解析当前产品,其他颜色的不管
 * @author tsingheng
 *
 */
public class ProductDetailParser {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductDetailParser.class);
	
	private String html;
	
	private ProductWrapper wrapper;
	
	private static final String STOCK_QUERY_URL = "http://stock.vip.com/detail/?merchandiseId={id}";

	public ProductDetailParser(ProductWrapper wrapper){
		this.wrapper = wrapper;
	}
	
	/**
	 * 商品名称
	 * 市场价
	 * 售卖价
	 * 主图
	 * 内容图
	 * 编码
	 * 尺码
	 * @throws ParserException 
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 * @throws InterruptedException 
	 */
	public void parse() throws ParserException, ClientProtocolException, IOException, InterruptedException{
		Parser parser = new Parser();
		parser.setURL(wrapper.getDetailUrl());
		
		logger.info("parsing product detail {}", wrapper.getDetailUrl());
		
		NodeFilter filter = new TagNameFilter("body");
		NodeList nodes = parser.extractAllNodesThatMatch(filter);
		html = nodes.elementAt(0).toHtml().replaceAll("figure|figcaption", "div");
		
//		Thread.sleep(2000);
		
		parserName();
		parseMarketPrice();
		parseSalesPrice();
		parseImages();
		parseContent();
		parseCode();
		parseInventories();
		parseColors();
	}
	
	private void parseColors() throws ParserException {
		Parser parser = new Parser();
		parser.setInputHTML(html);
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
								String id = link.getAttribute("id").replace("J-colorItem-", "");
								if(StringUtils.isNotBlank(wrapper.getProduct().getColors())){
									id = wrapper.getProduct().getColors() + "," + id;
								}
								wrapper.getProduct().setColors(id);
							}
						}
					}
				}
			}
		}
    }

	private void parserName() throws ParserException{
		Parser parser = new Parser();
		parser.setInputHTML(html);
		NodeFilter filter = new HasAttributeFilter("class", "pib-title-detail");
		NodeList nodes = parser.extractAllNodesThatMatch(filter);
		if(nodes != null && nodes.size() > 0){
			ParagraphTag p = (ParagraphTag) nodes.elementAt(0);
			wrapper.getProduct().setName(p.getStringText());
		}
	}
	
	private void parseMarketPrice() throws ParserException{
		Parser parser = new Parser();
		parser.setInputHTML(html);
		NodeFilter filter = new HasAttributeFilter("class", "pbox-market");
		NodeList nodes = parser.extractAllNodesThatMatch(filter);
		if(nodes != null && nodes.size() > 0){
			NodeList prices = nodes.elementAt(0).getChildren();
			if(prices != null){
				NodeIterator it = prices.elements();
				while(it.hasMoreNodes()){
					Node node = it.nextNode();
					if(node instanceof TextNode){
						String text = node.toHtml();
						if(text.matches("\\d*")){
							wrapper.getProduct().setMarketPrice(Double.parseDouble(text));
						}
					}
				}
			}
		}
	}
	
	private void parseSalesPrice() throws ParserException{
		Parser parser = new Parser();
		parser.setInputHTML(html);
		NodeFilter filter = new HasAttributeFilter("class", "pbox-price");
		NodeList nodes = parser.extractAllNodesThatMatch(filter);
		if(nodes != null && nodes.size() > 0){
			NodeList prices = nodes.elementAt(0).getChildren();
			if(prices != null){
				NodeIterator it = prices.elements();
				while(it.hasMoreNodes()){
					Node node = it.nextNode();
					if(node instanceof TextNode){
						String text = node.toHtml();
						if(text.matches("\\d*")){
							wrapper.getProduct().setSellPrice(Double.parseDouble(text));
						}
					}
				}
			}
		}
	}
	
	private void parseImages() throws ParserException{
		Parser parser = new Parser();
		parser.setInputHTML(html);
		NodeFilter filter = new HasAttributeFilter("class", "J-mer-bigImgZoom");
		NodeList nodes = parser.extractAllNodesThatMatch(filter);
		List<String> images = new ArrayList<String>();
		NodeIterator it = nodes.elements();
		while(it.hasMoreNodes()){
			LinkTag link = (LinkTag) it.nextNode();
			ImageTag image = (ImageTag) link.childAt(1);
			images.add(image.getImageURL().replace("_1.", "_{size}."));
		}
		wrapper.getProduct().setImages(StringUtils.join(images, ","));
	}
	
	private void parseContent() throws ParserException{
		Parser parser = new Parser();
		parser.setInputHTML(html);
		NodeFilter filter = null;
		if(html.contains("class=\"dc_img\"")){
			filter = new HasAttributeFilter("class", "dc_img");
		}else if(html.contains("class=\"pro-model-pic\"")){
			filter = new HasAttributeFilter("class", "pro-model-pic");
		}
		if(filter != null){
			NodeList nodes = parser.extractAllNodesThatMatch(filter);
			if(nodes != null && nodes.size() > 0 && nodes.elementAt(0) != null){
				wrapper.getProduct().setContent(nodes.elementAt(0).toHtml());
			}
		}
	}
	
	private void parseCode() throws ParserException{
		Parser parser = new Parser();
		parser.setInputHTML(html);
		NodeFilter filter = new HasAttributeFilter("class", "other-box");
		NodeList nodes = parser.extractAllNodesThatMatch(filter);
		if(nodes != null && nodes.size() > 0){
			CompositeTag tag = (CompositeTag) nodes.elementAt(0);
			wrapper.getProduct().setCode(tag.getStringText());
		}
	}
	
	private static final HttpClientBuilder HTTP_CLIENT_BUILDER = HttpClientBuilder.create();
	
	private void parseInventories() throws ClientProtocolException, IOException, InterruptedException{
		HttpClient client = HTTP_CLIENT_BUILDER.build();
		HttpGet get = new HttpGet(STOCK_QUERY_URL.replace("{id}", wrapper.getProduct().getVid()));
		HttpResponse response = client.execute(get);
		List<Inventory> list = new ArrayList<Inventory>();
		if(response.getEntity() != null){
			InputStream is = response.getEntity().getContent();
			String result = IOUtils.toString(is);
			IOUtils.closeQuietly(is);
			JSONObject data = JSONObject.parseObject(result);
			JSONArray items = data.getJSONArray("items");
			if(!items.isEmpty()){
				for(Object item : items){
					JSONObject obj = (JSONObject) item;
					Inventory inventory = new Inventory();
					inventory.setCode(obj.getString("sn"));
					inventory.setSize(obj.getString("name"));
					inventory.setStock(obj.getInteger("stock"));
					inventory.setSaled(obj.getInteger("sales"));
					inventory.setMin(obj.getInteger("min"));
					inventory.setMax(obj.getInteger("max"));
					list.add(inventory);
				}
			}
		}
		logger.info("find {} inventory items of {}", list.size(), wrapper.getProduct().getVid());
		wrapper.setInventories(list);
//		Thread.sleep(2000);
	}
	
}
