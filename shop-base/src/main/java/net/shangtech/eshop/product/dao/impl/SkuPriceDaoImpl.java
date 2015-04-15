package net.shangtech.eshop.product.dao.impl;

import java.util.List;

import net.shangtech.eshop.product.dao.SkuPriceDao;
import net.shangtech.eshop.product.entity.SkuPrice;
import net.shangtech.framework.orm.dao.hibernate.BaseDao;

import org.springframework.stereotype.Repository;

@Repository
public class SkuPriceDaoImpl extends BaseDao<SkuPrice> implements SkuPriceDao {

	@Override
    public SkuPrice getPrice(Long skuId, int quantity) {
	    return findOneByHql("where skuId=? and min<=? and max>=?", skuId, quantity, quantity);
    }

	@Override
    public List<SkuPrice> getPriceList(Long skuId) {
	    return findByProperty("skuId", skuId);
    }
	
}
