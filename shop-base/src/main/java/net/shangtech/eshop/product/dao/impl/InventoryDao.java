package net.shangtech.eshop.product.dao.impl;

import org.springframework.stereotype.Repository;

import net.shangtech.eshop.product.dao.IInventoryDao;
import net.shangtech.eshop.product.entity.Inventory;
import net.shangtech.framework.dao.hibernate.BaseDao;

@Repository
public class InventoryDao extends BaseDao<Inventory> implements IInventoryDao {

}
