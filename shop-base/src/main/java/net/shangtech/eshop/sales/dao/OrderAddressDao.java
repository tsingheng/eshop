package net.shangtech.eshop.sales.dao;

import net.shangtech.eshop.sales.entity.OrderAddress;
import net.shangtech.framework.orm.dao.IBaseDao;

public interface OrderAddressDao extends IBaseDao<OrderAddress> {
	OrderAddress findByOrderId(Long orderId);
}
