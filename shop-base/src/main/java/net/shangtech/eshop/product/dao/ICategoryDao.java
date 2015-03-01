package net.shangtech.eshop.product.dao;

import java.util.List;

import net.shangtech.eshop.product.entity.Category;
import net.shangtech.framework.dao.IBaseDao;

public interface ICategoryDao extends IBaseDao<Category> {
	List<Category> findByParentId(long parentId);
}
