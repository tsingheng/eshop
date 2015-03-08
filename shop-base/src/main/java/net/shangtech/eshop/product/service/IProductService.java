package net.shangtech.eshop.product.service;

import net.shangtech.eshop.product.dao.qbs.ProductQueryBean;
import net.shangtech.eshop.product.entity.Product;
import net.shangtech.framework.dao.support.Pagination;
import net.shangtech.framework.service.IBaseService;

public interface IProductService extends IBaseService<Product> {

	Pagination<Product> findByCategory(Long categoryId, ProductQueryBean qb, Pagination<Product> pagination);
	
}
