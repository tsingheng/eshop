package net.shangtech.eshop.solr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.shangtech.eshop.product.entity.Brand;
import net.shangtech.eshop.product.entity.Category;
import net.shangtech.eshop.product.entity.Inventory;
import net.shangtech.eshop.product.entity.Sku;
import net.shangtech.eshop.product.service.BrandService;
import net.shangtech.eshop.product.service.CategoryService;
import net.shangtech.eshop.product.service.InventoryService;
import net.shangtech.eshop.product.service.SkuService;
import net.shangtech.framework.dao.support.Pagination;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSON;

public class SolrService implements InitializingBean {
	
	private static final Logger logger = LoggerFactory.getLogger(SolrService.class);
	
	@Autowired private SkuService skuService;
	@Autowired private InventoryService inventoryService;
	@Autowired private CategoryService categoryService;
	@Autowired private BrandService brandService;
	
	private HttpSolrServer server = null;
	
	private String url;

	@Override
    public void afterPropertiesSet() throws Exception {
		server = new HttpSolrServer(url);
//		server.setAllowCompression(allowCompression);
//		server.setConnectionTimeout(timeout);
//		server.setDefaultMaxConnectionsPerHost(max);
    }
	
	public void saveSku(Sku sku) throws IOException, SolrServerException{
		SolrSku solrSku = sku2Solr(sku);
		server.addBean(solrSku);
		if(logger.isDebugEnabled()){
			logger.debug("ready to add {}", JSON.toJSON(solrSku));
		}
		server.commit();
	}
	
	public void saveSkuList(List<Sku> list) throws IOException, SolrServerException{
		if(!CollectionUtils.isEmpty(list)){
			List<SolrSku> solrSkus = new ArrayList<SolrSku>(list.size());
			for(Sku sku : list){
				solrSkus.add(sku2Solr(sku));
			}
			server.addBeans(solrSkus);
			server.commit();
		}
	}
	
	public void deleteByIds(List<String> ids) throws SolrServerException, IOException{
		server.deleteById(ids);
		server.commit();
	}
	
	public Pagination<SolrSku> findByCategory(String[] categoryCodes, Pagination<SolrSku> pagination) throws SolrServerException{
		SolrQuery query = new SolrQuery("*:*");
		for(String code : categoryCodes){
			query.addFilterQuery("categoryCodes:" + code);
		}
		query.setStart(pagination.getStart());
		query.setRows(pagination.getLimit());
		QueryResponse qr = server.query(query);
		pagination.setItems(qr.getBeans(SolrSku.class));
		pagination.setTotalCount(new Long(qr.getResults().getNumFound()).intValue());
		return pagination;
	}
	
	private SolrSku sku2Solr(Sku sku){
		SolrSku solrSku = new SolrSku();
		solrSku.setId(sku.getId());
		solrSku.setCode(sku.getCode());
		solrSku.setName(sku.getName());
		solrSku.setMarketPrice(sku.getMarketPrice());
		solrSku.setSellPrice(sku.getSellPrice());
		solrSku.setImage(sku.getImage());
		if(sku.getCategoryId() != null){
			List<Category> categoryWithParents = categoryService.findWithParents(sku.getCategoryId());
			if(!CollectionUtils.isEmpty(categoryWithParents)){
				List<String> categories = new ArrayList<String>(categoryWithParents.size());
				List<String> categoryCodes = new ArrayList<String>(categoryWithParents.size());
				for(Category category : categoryWithParents){
					categories.add(category.getName());
					categoryCodes.add(category.getCode());
				}
				solrSku.setCategories(categories);
				solrSku.setCategoryCodes(categoryCodes);
			}
		}
		if(sku.getBrandId() != null){
			Brand brand = brandService.find(sku.getBrandId());
			if(brand != null){
				solrSku.setBrandCode(brand.getCode());
				solrSku.setBrandName(brand.getName());
			}
		}
		List<String> sizes = new ArrayList<String>();
		List<Inventory> inventories = inventoryService.findBySkuId(sku.getId());
		if(!CollectionUtils.isEmpty(inventories)){
			for(Inventory inventory : inventories){
				sizes.add(inventory.getSize());
			}
		}
		solrSku.setSizes(sizes);
		return solrSku;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
