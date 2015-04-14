package net.shangtech.eshop.product.dao;

import java.util.List;

import net.shangtech.eshop.product.entity.SkuPrice;
import net.shangtech.framework.orm.dao.IBaseDao;

public interface SkuPriceDao extends IBaseDao<SkuPrice> {
	SkuPrice getPrice(Long skuId, int quantity);
	
	List<SkuPrice> getPriceList(Long skuId);
}
