package net.shangtech.eshop.product.service;

import java.util.List;

import net.shangtech.eshop.product.entity.Category;
import net.shangtech.framework.service.IBaseService;

public interface CategoryService extends IBaseService<Category> {
	Category findAllCategory();
	
	List<Category> findWithChildren(Long categoryId);
	
	List<Category> findWithParents(Long categoryId);
}
