package test.spider;

import net.shangtech.eshop.manager.spider.BrandSpider;
import net.shangtech.eshop.product.service.BrandService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class BrandSpiderTest {
	
	private static final Logger logger = LoggerFactory.getLogger(BrandSpiderTest.class);
	
	@Autowired private BrandService brandService;
	
	@Test
	public void test(){
		try{
			new BrandSpider(brandService).exec();
		}catch(Exception e){
			logger.error(e.getMessage(), e);
		}
	}
	
}
