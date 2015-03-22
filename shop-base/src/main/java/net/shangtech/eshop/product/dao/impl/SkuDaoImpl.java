package net.shangtech.eshop.product.dao.impl;

import net.shangtech.eshop.product.dao.SkuDao;
import net.shangtech.eshop.product.entity.Sku;
import net.shangtech.framework.dao.hibernate.BaseDao;

import org.springframework.stereotype.Repository;

@Repository
public class SkuDaoImpl extends BaseDao<Sku> implements SkuDao {

	@Override
    public Sku findByVid(String vid) {
	    return findOneByProperty("vid", vid);
    }

	@Override
    public Sku findByCode(String code) {
	    return findOneByProperty("code", code);
    }

}
