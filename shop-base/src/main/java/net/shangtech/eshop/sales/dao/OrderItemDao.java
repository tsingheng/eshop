package net.shangtech.eshop.sales.dao;

import java.util.List;

import net.shangtech.eshop.sales.entity.OrderItem;
import net.shangtech.framework.orm.dao.IBaseDao;

public interface OrderItemDao extends IBaseDao<OrderItem> {
	List<OrderItem> findByOrderId(Long orderId);
}
