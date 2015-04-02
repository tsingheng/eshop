package net.shangtech.eshop.product.dao;

import net.shangtech.eshop.product.entity.Brand;
import net.shangtech.framework.orm.dao.IBaseDao;

public interface BrandDao extends IBaseDao<Brand> {
	Brand findBySn(String sn);
	Brand findByCode(String code);
}
