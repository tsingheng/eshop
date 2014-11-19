package net.shangtech.shop.product.dao.impl;

import net.shangtech.framework.dao.hibernate.BaseDao;
import net.shangtech.shop.product.dao.IProductInventoryDao;
import net.shangtech.shop.product.entity.ProductInventory;
import org.springframework.stereotype.Repository;

@Repository
public class ProductInventoryDao extends BaseDao<ProductInventory> implements IProductInventoryDao {

}
