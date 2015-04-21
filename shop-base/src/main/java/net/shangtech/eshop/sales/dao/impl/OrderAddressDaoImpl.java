package net.shangtech.eshop.sales.dao.impl;

import org.springframework.stereotype.Repository;

import net.shangtech.eshop.sales.dao.OrderAddressDao;
import net.shangtech.eshop.sales.entity.OrderAddress;
import net.shangtech.framework.orm.dao.hibernate.BaseDao;

@Repository
public class OrderAddressDaoImpl extends BaseDao<OrderAddress> implements OrderAddressDao {

	@Override
	public OrderAddress findByOrderId(Long orderId) {
		return findOneByProperty("orderId", orderId);
	}

}
