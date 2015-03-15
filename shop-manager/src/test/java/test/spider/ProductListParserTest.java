package test.spider;

import net.shangtech.eshop.manager.spider.ProductListParser;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductListParserTest {

	private static final Logger logger = LoggerFactory.getLogger(ProductListParserTest.class);
	
	@Test
	public void textNextPage(){
		try{
			ProductListParser parser = new ProductListParser("http://category.vip.com/search-2-0-1.html?q=3|7860||&rp=7856|7857#catPerPos");
			while(parser.hasMore()){
				logger.info(parser.getUrl());
				parser.parseNextPageUrl();
			}
		}catch(Exception e){
			logger.error(e.getMessage(), e);
		}
	}
	
}
