package net.shangtech.eshop.sales.service.impl;

import net.shangtech.eshop.account.dao.MemberAddressDao;
import net.shangtech.eshop.account.entity.MemberAddress;
import net.shangtech.eshop.sales.dao.OrderDao;
import net.shangtech.eshop.sales.dao.OrderItemDao;
import net.shangtech.eshop.sales.entity.Order;
import net.shangtech.eshop.sales.service.OrderService;
import net.shangtech.eshop.sales.service.bo.OrderBo;
import net.shangtech.framework.service.BaseService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderServiceImpl extends BaseService<Order> implements OrderService {
	
	@Autowired private OrderDao dao;
	@Autowired private OrderItemDao orderItemDao;
	@Autowired private MemberAddressDao addressDao;
	@Override
	public Order createOrder(OrderBo bo) {
		Order order = new Order();
		BeanUtils.copyProperties(bo, order);
		
		MemberAddress address = addressDao.find(bo.getMemberAddressId());
		order.setCity(address.getCity());
		
		return order;
	}

}
