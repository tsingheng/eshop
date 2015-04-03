package net.shangtech.eshop.sales.dao;

import java.util.List;

import net.shangtech.eshop.sales.entity.Order;
import net.shangtech.framework.orm.dao.IBaseDao;
import net.shangtech.framework.orm.dao.support.Pagination;

public interface OrderDao extends IBaseDao<Order> {
	List<Order> findByMemberId(Long memberId);
	
	Pagination<Order> findByMemberId(Pagination<Order> pagination, Long memberId);
}
