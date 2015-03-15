package test.spider;

import net.shangtech.eshop.manager.spider.ProductDetailParser;
import net.shangtech.eshop.manager.spider.suport.ProductWrapper;
import net.shangtech.eshop.product.entity.Sku;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

public class ProductDetailParserTest {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductDetailParserTest.class);
	
	@Test
	public void testParseProductDetail(){
		ProductWrapper wrapper = new ProductWrapper();
		Sku sku = new Sku();
		sku.setVid("49288236");
		wrapper.setProduct(sku);
		try{
			new ProductDetailParser(wrapper).parse();
			logger.info(JSON.toJSONString(wrapper));
		}catch(Exception e){
			logger.error("", e);
		}
	}
	
}
