package net.shangtech.eshop.manager.spider;

import java.util.LinkedList;
import java.util.List;

import net.shangtech.eshop.product.entity.Brand;
import net.shangtech.eshop.product.service.BrandService;

import org.apache.commons.lang3.StringUtils;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.tags.Div;
import org.htmlparser.tags.ImageTag;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeIterator;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

public class BrandSpider {
	
	private static final String BRAND_URL = "http://brand.vip.com/";
	
	private static final Logger logger = LoggerFactory.getLogger(BrandSpider.class);
	
	private BrandService brandService;
	
	public BrandSpider(BrandService brandService){
		this.brandService = brandService;
	}
	
	public void exec() throws ParserException, InterruptedException{
		Parser parser = new Parser();
		parser.setURL(BRAND_URL);
		NodeFilter filter = new HasAttributeFilter("class", "index-more");
		NodeList nodes = parser.extractAllNodesThatMatch(filter);
		if(nodes != null){
			NodeIterator it = nodes.elements();
			while (it.hasMoreNodes()) {
	            LinkTag link = (LinkTag) it.nextNode();
	            logger.info("find brand link [{}]", link.getLink());
	            BrandListParser listParser = new BrandListParser(link.getLink());
	            List<Brand> list = listParser.parse();
	            logger.info("find {} brands", list.size());
	            if(!CollectionUtils.isEmpty(list)){
	            	for(Brand brand : list){
	            		Brand old = brandService.findBySn(brand.getSn());
	            		if(old != null){
	            			logger.info("brand [{}] exists", brand.getSn());
	            			continue;
	            		}
	            		brandService.save(brand);
	            	}
	            }
	            Thread.sleep(1000);
            }
		}
	}
	
}
class BrandListParser{
	private String url;
	public BrandListParser(String url){
		this.url = url;
	}
	public List<Brand> parse() throws ParserException{
		Parser parser = new Parser();
		parser.setURL(url);
		NodeFilter filter = new HasAttributeFilter("class", "J_myFav_tag");
		NodeList nodes = parser.extractAllNodesThatMatch(filter);
		List<Brand> list = new LinkedList<Brand>();
		if(nodes != null){
			NodeIterator it = nodes.elements();
			while(it.hasMoreNodes()){
				Div tag = (Div) it.nextNode();
				NodeList tags = tag.getParent().getChildren();
				LinkTag link = (LinkTag) tags.elementAt(0);
				ImageTag image =  (ImageTag) link.childAt(1);
				LinkTag nameEn = (LinkTag) tags.elementAt(2).getChildren().elementAt(1);
				LinkTag nameCn = (LinkTag) tags.elementAt(4).getChildren().elementAt(1);
				Brand brand = new Brand();
				String href = link.getAttribute("href");
				brand.setCode(href.substring(1, href.length()-1));
				brand.setEnglishName(StringUtils.trim(nameEn.getLinkText()));
				brand.setLogo(image.getAttribute("data-original"));
				brand.setName(StringUtils.trim(nameCn.getLinkText()));
				brand.setSn(tag.getAttribute("sn"));
				list.add(brand);
			}
		}
		return list;
	}
}
