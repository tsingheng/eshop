package net.shangtech.eshop.sales.service;

import net.shangtech.eshop.sales.entity.Order;
import net.shangtech.eshop.sales.service.bo.OrderBo;
import net.shangtech.framework.service.IBaseService;

public interface OrderService extends IBaseService<Order> {
	Order createOrder(OrderBo bo);
}
