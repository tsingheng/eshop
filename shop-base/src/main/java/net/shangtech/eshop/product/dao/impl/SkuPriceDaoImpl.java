package net.shangtech.eshop.product.dao.impl;

import java.util.List;

import net.shangtech.eshop.product.dao.SkuPriceDao;
import net.shangtech.eshop.product.entity.SkuPrice;
import net.shangtech.framework.orm.dao.hibernate.BaseDao;
import net.shangtech.framework.orm.dao.support.MapHolder;

import org.springframework.stereotype.Repository;

@Repository
public class SkuPriceDaoImpl extends BaseDao<SkuPrice> implements SkuPriceDao {

	@Override
    public SkuPrice getPrice(Long skuId, int quantity) {
		MapHolder<String> holder = new MapHolder<String>();
		holder.put("skuId", skuId);
		holder.put("quantity", quantity);
		return findOneBySql("SkuPrice.getPrice", holder);
    }

	@Override
    public List<SkuPrice> getPriceList(Long skuId) {
	    return findByProperty("skuId", skuId);
    }
	
}
