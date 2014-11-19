package net.shangtech.shop.product.dao.impl;

import net.shangtech.framework.dao.hibernate.BaseDao;
import net.shangtech.shop.product.dao.IProductToCategoryDao;
import net.shangtech.shop.product.entity.ProductToCategory;
import org.springframework.stereotype.Repository;

@Repository
public class ProductToCategoryDao extends BaseDao<ProductToCategory> implements IProductToCategoryDao {

}
