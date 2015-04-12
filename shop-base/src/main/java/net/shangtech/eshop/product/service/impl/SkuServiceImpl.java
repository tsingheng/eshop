package net.shangtech.eshop.product.service.impl;

import java.util.List;

import net.shangtech.eshop.product.dao.CategoryDao;
import net.shangtech.eshop.product.dao.SkuDao;
import net.shangtech.eshop.product.entity.Sku;
import net.shangtech.eshop.product.service.SkuService;
import net.shangtech.framework.orm.dao.support.Pagination;
import net.shangtech.framework.orm.service.BaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SkuServiceImpl extends BaseService<Sku> implements SkuService {

	@Autowired private SkuDao dao;
	
	@Autowired private CategoryDao categoryDao;

	@Override
    public Sku findByVid(String vid) {
	    return dao.findByVid(vid);
    }

	@Override
    public Sku findByCode(String code) {
	    return dao.findByCode(code);
    }

	@Override
    public List<Sku> findByCategoryId(Long categoryId, Integer size) {
		Pagination<Sku> pagination = new Pagination<Sku>();
		pagination.setStart(0);
		pagination.setLimit(size);
	    return dao.findByCategoryId(categoryId, pagination).getItems();
    }
}
