package net.shangtech.eshop.product.service;

import java.util.List;

import net.shangtech.eshop.product.entity.SkuPrice;
import net.shangtech.framework.orm.service.IBaseService;

public interface SkuPriceService extends IBaseService<SkuPrice> {
	/**
	 * 查询批发价格
	 * @param skuId
	 * @param quantity
	 * @return
	 */
	SkuPrice getPrice(Long skuId, int quantity);
	
	/**
	 * 查询批发起步价
	 * @param skuId
	 * @return
	 */
	SkuPrice getFirstPrice(Long skuId);
	
	List<SkuPrice> getPriceList(Long skuId);
}
