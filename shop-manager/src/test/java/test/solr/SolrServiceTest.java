package test.solr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.shangtech.eshop.product.entity.Sku;
import net.shangtech.eshop.product.service.BrandService;
import net.shangtech.eshop.product.service.CategoryService;
import net.shangtech.eshop.product.service.InventoryService;
import net.shangtech.eshop.product.service.SkuService;
import net.shangtech.eshop.solr.SolrService;
import net.shangtech.framework.dao.support.Pagination;

import org.apache.solr.client.solrj.SolrServerException;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import test.BaseSpringTest;

public class SolrServiceTest extends BaseSpringTest {
	
	private static final Logger logger = LoggerFactory.getLogger(SolrServiceTest.class);

	@Autowired private SkuService skuService;
	@Autowired private InventoryService inventoryService;
	@Autowired private CategoryService categoryService;
	@Autowired private BrandService brandService;
	@Autowired private SolrService solrService;
	
	@Test
	public void addAllToSolr() throws IOException, SolrServerException{
		Pagination<Sku> pagination = new Pagination<Sku>();
		pagination.setLimit(20);
		do{
			pagination = skuService.findAllByPage(pagination);
			logger.info("processing page {} of {}", pagination.getPageNo(), pagination.getTotalPage());
			solrService.saveSkuList(pagination.getItems());
			pagination.setPageNo(pagination.getPageNo()+1);
		}while(!CollectionUtils.isEmpty(pagination.getItems()));
	}
	
	@Test
	public void testAddSku(){
		Pagination<Sku> pagination = new Pagination<Sku>(10);
		skuService.findAllByPage(pagination);
		for(Sku sku : pagination.getItems()){
			try{
				solrService.saveSku(sku);
			}catch(Exception e){
				logger.error(e.getMessage(), e);
			}
		}
	}
	
	@Test
	public void testDelete() throws SolrServerException, IOException{
		List<String> ids = new ArrayList<String>();
		for(int i = 1; i < 11; i++){
			ids.add(String.valueOf(i));
		}
		solrService.deleteByIds(ids);
	}
	
}
