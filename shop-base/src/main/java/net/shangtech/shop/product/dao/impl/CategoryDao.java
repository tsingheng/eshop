package net.shangtech.shop.product.dao.impl;

import java.util.List;

import net.shangtech.framework.dao.hibernate.BaseDao;
import net.shangtech.framework.dao.support.MapHolder;
import net.shangtech.shop.product.dao.ICategoryDao;
import net.shangtech.shop.product.entity.Category;

import org.springframework.stereotype.Repository;

@Repository
public class CategoryDao extends BaseDao<Category> implements ICategoryDao {

	@Override
	public List<Category> findByParentId(Long parentId) {
		return findByProperties(MapHolder.instance("parentId", parentId));
	}

}
