package net.shangtech.eshop.product.dao.impl;

import net.shangtech.eshop.product.dao.BrandDao;
import net.shangtech.eshop.product.entity.Brand;
import net.shangtech.framework.orm.dao.hibernate.BaseDao;

import org.springframework.stereotype.Repository;

@Repository
public class BrandDaoImpl extends BaseDao<Brand> implements BrandDao {

	@Override
    public Brand findBySn(String sn) {
	    return findOneByProperty("sn", sn);
    }

	@Override
    public Brand findByCode(String code) {
	    return findOneByProperty("code", code);
    }

}
