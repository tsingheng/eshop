package net.shangtech.eshop.product.dao.impl;

import org.springframework.stereotype.Repository;

import net.shangtech.eshop.product.dao.IBrandDao;
import net.shangtech.eshop.product.entity.Brand;
import net.shangtech.framework.dao.hibernate.BaseDao;

@Repository
public class BrandDao extends BaseDao<Brand> implements IBrandDao {

	@Override
    public Brand findBySn(String sn) {
	    return findOneByProperty("sn", sn);
    }

	@Override
    public Brand findByCode(String code) {
	    return findOneByProperty("code", code);
    }

}
