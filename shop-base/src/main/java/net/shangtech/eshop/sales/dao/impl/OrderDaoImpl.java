package net.shangtech.eshop.sales.dao.impl;

import net.shangtech.eshop.sales.dao.OrderDao;
import net.shangtech.eshop.sales.entity.Order;
import net.shangtech.framework.orm.dao.hibernate.BaseDao;

import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImpl extends BaseDao<Order> implements OrderDao {

}
