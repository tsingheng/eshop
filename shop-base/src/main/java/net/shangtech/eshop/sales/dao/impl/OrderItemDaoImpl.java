package net.shangtech.eshop.sales.dao.impl;

import java.util.List;

import net.shangtech.eshop.sales.dao.OrderItemDao;
import net.shangtech.eshop.sales.entity.OrderItem;
import net.shangtech.framework.orm.dao.hibernate.BaseDao;

import org.springframework.stereotype.Repository;

@Repository
public class OrderItemDaoImpl extends BaseDao<OrderItem> implements OrderItemDao {

	@Override
	public List<OrderItem> findByOrderId(Long orderId) {
		return findByProperty("orderId", orderId);
	}

}
