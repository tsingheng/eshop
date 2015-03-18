package shop.test.solr;

import net.shangtech.eshop.solr.SolrService;
import net.shangtech.eshop.solr.SolrSku;
import net.shangtech.framework.dao.support.Pagination;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;

import shop.test.BaseSpringTest;

public class SolrTest extends BaseSpringTest {
	
	private static final Logger logger = LoggerFactory.getLogger(SolrTest.class);
	
	@Autowired private SolrService solrService;
	
	@Test
	public void testSolrQuery(){
		try{
			Pagination<SolrSku> pagination = new Pagination<SolrSku>();
			pagination = solrService.findByCategory(new String[]{"tops"}, pagination);
			logger.info(String.format("query %d items of %d, page %d of %d", pagination.getItems().size(), pagination.getTotalCount(), pagination.getPageNo(), pagination.getTotalPage()));
			for(SolrSku sku : pagination.getItems()){
				logger.info(JSON.toJSONString(sku));
			}
		}catch(Exception e){
			logger.error(e.getMessage(), e);
		}
	}
}
