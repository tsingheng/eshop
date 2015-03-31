package net.shangtech.eshop.sales.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.shangtech.eshop.sales.dao.OrderDao;
import net.shangtech.eshop.sales.dao.OrderItemDao;
import net.shangtech.eshop.sales.entity.Order;
import net.shangtech.eshop.sales.entity.OrderItem;
import net.shangtech.eshop.sales.service.OrderService;
import net.shangtech.framework.service.BaseService;

@Service
@Transactional
public class OrderServiceImpl extends BaseService<Order> implements OrderService {
	
	@Autowired private OrderDao dao;
	@Autowired private OrderItemDao orderItemDao;
	
	@Override
	public void createOrder(Order order, List<OrderItem> items) {
		
	}
}
