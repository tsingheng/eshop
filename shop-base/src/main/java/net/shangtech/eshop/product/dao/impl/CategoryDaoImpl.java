package net.shangtech.eshop.product.dao.impl;

import org.springframework.stereotype.Repository;

import net.shangtech.eshop.product.dao.ICategoryDao;
import net.shangtech.eshop.product.entity.Category;
import net.shangtech.framework.dao.hibernate.BaseDao;

@Repository
public class CategoryDaoImpl extends BaseDao<Category> implements ICategoryDao {

}
