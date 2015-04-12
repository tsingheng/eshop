package net.shangtech.eshop.product.dao;

import net.shangtech.eshop.product.entity.Sku;
import net.shangtech.framework.orm.dao.IBaseDao;
import net.shangtech.framework.orm.dao.support.Pagination;

public interface SkuDao extends IBaseDao<Sku> {
	Sku findByVid(String vid);
	
	Sku findByCode(String code);
	
	Pagination<Sku> findByCategoryId(Long categoryId, Pagination<Sku> pagination);
}
