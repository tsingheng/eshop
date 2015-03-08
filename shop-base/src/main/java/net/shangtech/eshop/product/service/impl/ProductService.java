package net.shangtech.eshop.product.service.impl;

import net.shangtech.eshop.product.dao.ICategoryDao;
import net.shangtech.eshop.product.dao.IProductDao;
import net.shangtech.eshop.product.dao.qbs.ProductQueryBean;
import net.shangtech.eshop.product.entity.Category;
import net.shangtech.eshop.product.entity.Product;
import net.shangtech.eshop.product.service.IProductService;
import net.shangtech.framework.dao.support.Pagination;
import net.shangtech.framework.service.BaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductService extends BaseService<Product> implements IProductService {

	@Autowired private IProductDao dao;
	
	@Autowired private ICategoryDao categoryDao;

	@Override
    public Pagination<Product> findByCategory(Long categoryId, ProductQueryBean qb, Pagination<Product> pagination) {
	    Category category = categoryDao.find(categoryId);
	    qb.setCategory(category);
	    return dao.findPage(qb, pagination);
    }
}
