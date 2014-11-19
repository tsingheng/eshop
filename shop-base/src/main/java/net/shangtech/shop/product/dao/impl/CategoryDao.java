package net.shangtech.shop.product.dao.impl;

import net.shangtech.framework.dao.hibernate.BaseDao;
import net.shangtech.shop.product.dao.ICategoryDao;
import net.shangtech.shop.product.entity.Category;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDao extends BaseDao<Category> implements ICategoryDao {

}
