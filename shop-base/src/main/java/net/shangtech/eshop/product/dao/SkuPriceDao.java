package net.shangtech.eshop.product.dao;

import java.util.List;

import net.shangtech.eshop.product.entity.SkuPrice;
import net.shangtech.framework.orm.dao.IBaseDao;

public interface SkuPriceDao extends IBaseDao<SkuPrice> {
	SkuPrice getPrice(Long skuId, int quantity);
	
	/**
	 * 查询批发起步价
	 * @param skuId
	 * @return
	 */
	SkuPrice getFirstPrice(Long skuId);
	
	List<SkuPrice> getPriceList(Long skuId);
}
