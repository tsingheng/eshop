package net.shangtech.eshop.sales.dao;

import net.shangtech.eshop.sales.entity.BillAddress;
import net.shangtech.framework.orm.dao.IBaseDao;

public interface BillAddressDao extends IBaseDao<BillAddress> {
	BillAddress findByOrderId(Long orderId);
}
