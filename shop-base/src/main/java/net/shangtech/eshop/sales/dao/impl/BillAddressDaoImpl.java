package net.shangtech.eshop.sales.dao.impl;

import org.springframework.stereotype.Repository;

import net.shangtech.eshop.sales.dao.BillAddressDao;
import net.shangtech.eshop.sales.entity.BillAddress;
import net.shangtech.framework.orm.dao.hibernate.BaseDao;

@Repository
public class BillAddressDaoImpl extends BaseDao<BillAddress> implements BillAddressDao {

	@Override
	public BillAddress findByOrderId(Long orderId) {
		return findOneByProperty("orderId", orderId);
	}

}
