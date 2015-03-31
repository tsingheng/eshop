package net.shangtech.eshop.sales.dao.impl;

import org.springframework.stereotype.Repository;

import net.shangtech.eshop.sales.dao.OrderDao;
import net.shangtech.eshop.sales.entity.Order;
import net.shangtech.framework.dao.hibernate.BaseDao;

@Repository
public class OrderDaoImpl extends BaseDao<Order> implements OrderDao {

}
