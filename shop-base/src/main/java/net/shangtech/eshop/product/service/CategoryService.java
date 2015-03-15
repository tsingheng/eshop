package net.shangtech.eshop.product.service;

import net.shangtech.eshop.product.entity.Category;
import net.shangtech.framework.service.IBaseService;

public interface CategoryService extends IBaseService<Category> {
	Category findAllCategory();
}
