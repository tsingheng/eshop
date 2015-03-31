package net.shangtech.eshop.sales.dao.impl;

import org.springframework.stereotype.Repository;

import net.shangtech.eshop.sales.dao.OrderItemDao;
import net.shangtech.eshop.sales.entity.OrderItem;
import net.shangtech.framework.dao.hibernate.BaseDao;

@Repository
public class OrderItemDaoImpl extends BaseDao<OrderItem> implements OrderItemDao {

}
