package net.shangtech.eshop.sales.dao.impl;

import java.util.List;

import net.shangtech.eshop.sales.dao.OrderDao;
import net.shangtech.eshop.sales.entity.Order;
import net.shangtech.framework.orm.dao.hibernate.BaseDao;
import net.shangtech.framework.orm.dao.support.Pagination;

import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImpl extends BaseDao<Order> implements OrderDao {

	@Override
	public List<Order> findByMemberId(Long memberId) {
		return findByProperty("memberId", memberId);
	}

	@Override
	public Pagination<Order> findByMemberId(Pagination<Order> pagination, Long memberId) {
		return findPageByProperties("memberId", memberId, pagination);
	}

}
