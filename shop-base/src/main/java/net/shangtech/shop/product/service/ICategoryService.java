package net.shangtech.shop.product.service;

import java.util.List;

import net.shangtech.framework.service.IBaseService;
import net.shangtech.shop.product.entity.Category;

public interface ICategoryService extends IBaseService<Category> {
	
	List<Category> findByParentId(Long parentId);
	
	boolean hasChildren(Long id);
	
}
