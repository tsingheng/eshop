package net.shangtech.eshop.product.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import net.shangtech.eshop.product.entity.Category;
import net.shangtech.eshop.product.service.ICategoryService;
import net.shangtech.framework.service.BaseService;

@Service
@Transactional
public class CategoryServiceImpl extends BaseService<Category> implements ICategoryService {
	
}
