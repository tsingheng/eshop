package spider.test;

import java.util.List;

import net.shangtech.eshop.manager.spider.CategoryBrandParser;
import net.shangtech.eshop.manager.spider.suport.CategoryBrandWrapper;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

public class CategoryBrandParserTest {

	private static final Logger logger = LoggerFactory.getLogger(CategoryBrandParserTest.class);
	
	@Test
	public void test(){
		try{
			CategoryBrandParser parser = new CategoryBrandParser("http://category.vip.com/search-2-0-1.html?q=3|7866&wz=2");
			List<CategoryBrandWrapper> brands = parser.parse();
			for(CategoryBrandWrapper wrapper : brands){
				logger.info(JSON.toJSONString(wrapper));
			}
		}catch(Exception e){
			logger.error(e.getMessage(), e);
		}
	}
	
}
