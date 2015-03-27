package net.shangtech.eshop.sales.dao.impl;

import org.springframework.stereotype.Repository;

import net.shangtech.eshop.sales.dao.ShoppingCartItemDao;
import net.shangtech.eshop.sales.entity.ShoppingCartItem;
import net.shangtech.framework.dao.hibernate.BaseDao;

@Repository
public class ShoppingCartItemDaoImpl extends BaseDao<ShoppingCartItem> implements ShoppingCartItemDao {

}
