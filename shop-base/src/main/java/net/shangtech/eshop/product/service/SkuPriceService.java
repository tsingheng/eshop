package net.shangtech.eshop.product.service;

import java.util.List;

import net.shangtech.eshop.product.entity.SkuPrice;
import net.shangtech.framework.orm.service.IBaseService;

public interface SkuPriceService extends IBaseService<SkuPrice> {
	SkuPrice getPrice(Long skuId, int quantity);
	
	List<SkuPrice> getPriceList(Long skuId);
}
