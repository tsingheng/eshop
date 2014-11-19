package net.shangtech.shop.product.dao.impl;

import net.shangtech.framework.dao.hibernate.BaseDao;
import net.shangtech.shop.product.dao.IProductDao;
import net.shangtech.shop.product.entity.Product;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao extends BaseDao<Product> implements IProductDao {

}
