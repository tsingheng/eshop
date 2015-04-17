package test.sku;

import java.util.List;

import net.shangtech.eshop.product.entity.Sku;
import net.shangtech.eshop.product.entity.SkuPrice;
import net.shangtech.eshop.product.service.SkuPriceService;
import net.shangtech.eshop.product.service.SkuService;
import net.shangtech.framework.orm.dao.support.Pagination;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import test.BaseSpringTest;

public class SkuTest extends BaseSpringTest {
	
	private static final Logger logger = LoggerFactory.getLogger(SkuTest.class);

	@Autowired private SkuService skuService;
	
	@Autowired private SkuPriceService skuPriceService;
	
	@Test
	public void initSkuPrice(){
		Pagination<Sku> pagination = new Pagination<Sku>();
		pagination.setLimit(20);
		do{
			pagination = skuService.findAllByPage(pagination);
			logger.info("processing page {} of {}", pagination.getPageNo(), pagination.getTotalPage());
			for(Sku sku : pagination.getItems()){
				List<SkuPrice> skuPriceList = skuPriceService.getPriceList(sku.getId());
				if(!CollectionUtils.isEmpty(skuPriceList)){
					continue;
				}
				SkuPrice skuPrice1 = new SkuPrice();
				skuPrice1.setMin(1);
				skuPrice1.setMax(300);
				skuPrice1.setPrice(15.0);
				skuPrice1.setSkuId(sku.getId());
				skuPriceService.save(skuPrice1);
				
				SkuPrice skuPrice2 = new SkuPrice();
				skuPrice2.setMin(301);
				skuPrice2.setMax(600);
				skuPrice2.setPrice(14.0);
				skuPrice2.setSkuId(sku.getId());
				skuPriceService.save(skuPrice2);
				
				SkuPrice skuPrice3 = new SkuPrice();
				skuPrice3.setMin(601);
				skuPrice3.setMax(1000);
				skuPrice3.setPrice(12.0);
				skuPrice3.setSkuId(sku.getId());
				skuPriceService.save(skuPrice3);
			}
			pagination.setPageNo(pagination.getPageNo()+1);
		}while(!CollectionUtils.isEmpty(pagination.getItems()));
	}
	
}
