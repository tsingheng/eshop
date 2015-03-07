package net.shangtech.eshop.product.dao.impl;

import net.shangtech.eshop.product.dao.IProductDao;
import net.shangtech.eshop.product.entity.Product;
import net.shangtech.framework.dao.hibernate.BaseDao;

import org.springframework.stereotype.Repository;

@Repository
public class ProductDao extends BaseDao<Product> implements IProductDao {

}
