package net.shangtech.shop.product.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import net.shangtech.framework.service.BaseService;
import net.shangtech.shop.product.dao.ICategoryDao;
import net.shangtech.shop.product.entity.Category;
import net.shangtech.shop.product.service.ICategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CategoryService extends BaseService<Category> implements ICategoryService {

	@Autowired private ICategoryDao dao;
	
	@Override
	public List<Category> findByParentId(Long parentId) {
		return dao.findByParentId(parentId);
	}
	
}
