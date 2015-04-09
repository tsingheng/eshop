package net.shangtech.eshop.sales.service.impl;

import java.util.Date;
import java.util.List;

import net.shangtech.eshop.account.dao.MemberAddressDao;
import net.shangtech.eshop.account.entity.MemberAddress;
import net.shangtech.eshop.sales.dao.OrderDao;
import net.shangtech.eshop.sales.dao.OrderItemDao;
import net.shangtech.eshop.sales.entity.Order;
import net.shangtech.eshop.sales.entity.OrderItem;
import net.shangtech.eshop.sales.service.OrderService;
import net.shangtech.eshop.sales.service.bo.OrderBo;
import net.shangtech.eshop.sales.service.bo.OrderItemBo;
import net.shangtech.framework.orm.dao.support.Pagination;
import net.shangtech.framework.orm.service.BaseService;

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
		
		//validate bo
		
		Order order = new Order();
		BeanUtils.copyProperties(bo, order);
		
		MemberAddress address = addressDao.find(bo.getMemberAddressId());
		order.setCountry(address.getCountry());
		order.setProvince(address.getProvince());
		order.setCity(address.getCity());
		order.setDistrict(address.getDistrict());
		order.setStreet(address.getStreet());
		order.setContact(address.getContact());
		order.setPostcode(address.getPostcode());
		order.setMobile(address.getMobile());
		
		order.setCreateTime(new Date());
		
		dao.save(order);
		for(OrderItemBo itemBo : bo.getItems()){
			OrderItem item = new OrderItem();
			BeanUtils.copyProperties(itemBo, item);
			item.setOrderId(order.getId());
			orderItemDao.save(item);
		}
		return order;
	}
	@Override
	public Pagination<Order> findByMemberId(Pagination<Order> pagination, Long memberId) {
		return dao.findByMemberId(pagination, memberId);
	}
	
	@Override
	public List<OrderItem> findItemsByOrderId(Long orderId) {
		return orderItemDao.findByOrderId(orderId);
	}

}
