package test.spider;

import net.shangtech.eshop.manager.spider.alibaba.AliSpider;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import test.BaseSpringTest;

public class AliSpiderTest extends BaseSpringTest {
	
	private static final Logger logger = LoggerFactory.getLogger(AliSpiderTest.class);
	
	@Autowired private AliSpider spider;
	
	@Test
	public void testCategory(){
		try{
			spider.parseCategories();
		}catch(Exception e){
			logger.error("spider error", e);
		}
	}
	
	@Test
	public void testProducts(){
		try{
			spider.parseProducts();
		}catch(Exception e){
			logger.error("spider error", e);
		}
	}
}
