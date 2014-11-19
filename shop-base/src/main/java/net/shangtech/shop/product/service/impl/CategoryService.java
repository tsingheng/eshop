package net.shangtech.shop.product.service.impl;

import javax.transaction.Transactional;

import net.shangtech.framework.service.BaseService;
import net.shangtech.shop.product.entity.Category;
import net.shangtech.shop.product.service.ICategoryService;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class CategoryService extends BaseService<Category> implements ICategoryService {
	
}
