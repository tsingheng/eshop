package shop.test.orm;

import java.util.List;

import net.shangtech.eshop.sales.command.FreightTemplate;
import net.shangtech.eshop.sales.service.FreightService;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;

import shop.test.BaseSpringTest;

public class SqlQueryTest extends BaseSpringTest {

	private static final Logger logger = LoggerFactory.getLogger(SqlQueryTest.class);
	
	@Autowired private FreightService freightService;
	
	@Test
	public void testFreightTemplate(){
		List<FreightTemplate> templates = freightService.findByShippingId(1L);
		for(FreightTemplate template : templates){
			logger.info(JSON.toJSONString(template));
		}
	}
	
}
