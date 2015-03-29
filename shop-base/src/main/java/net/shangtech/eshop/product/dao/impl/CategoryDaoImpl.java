package net.shangtech.eshop.product.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.shangtech.eshop.product.dao.CategoryDao;
import net.shangtech.eshop.product.entity.Category;
import net.shangtech.framework.dao.hibernate.BaseDao;
import net.shangtech.framework.dao.support.MapHolder;

@Repository
public class CategoryDaoImpl extends BaseDao<Category> implements CategoryDao {

	@Override
    public List<Category> findByParentId(long parentId) {
	    return findByProperty("parentId", parentId);
    }

	@Override
    public Category findByCode(String code) {
	    return findOneByProperty("code", code);
    }

	@Override
    public Category findByCodeAndRootId(String code, Long rootId) {
		MapHolder<String> holder = new MapHolder<String>();
		holder.put("code", code);
		holder.put("rootId", rootId);
	    return findOneByProperties(holder);
    }

}
