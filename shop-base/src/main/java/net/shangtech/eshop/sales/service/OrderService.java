package net.shangtech.eshop.sales.service;

import java.util.List;

import net.shangtech.eshop.sales.entity.Order;
import net.shangtech.eshop.sales.entity.OrderItem;
import net.shangtech.eshop.sales.service.bo.OrderBo;
import net.shangtech.framework.orm.dao.support.Pagination;
import net.shangtech.framework.orm.service.IBaseService;

public interface OrderService extends IBaseService<Order> {
	Order createOrder(OrderBo bo);
	
	Pagination<Order> findByMemberId(Pagination<Order> pagination, Long memberId);
	
	List<OrderItem> findItemsByOrderId(Long orderId);
}
