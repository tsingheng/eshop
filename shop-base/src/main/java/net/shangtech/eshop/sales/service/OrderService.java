package net.shangtech.eshop.sales.service;

import java.util.List;

import net.shangtech.eshop.sales.entity.Order;
import net.shangtech.eshop.sales.entity.OrderItem;
import net.shangtech.framework.service.IBaseService;

public interface OrderService extends IBaseService<Order> {
	void createOrder(Order order, List<OrderItem> items);
}
