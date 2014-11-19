package net.shangtech.shop.product.dao;

import java.util.List;

import net.shangtech.framework.dao.IBaseDao;
import net.shangtech.shop.product.entity.Category;
public interface ICategoryDao extends IBaseDao<Category> {
	List<Category> findByParentId(Long parentId);
}
