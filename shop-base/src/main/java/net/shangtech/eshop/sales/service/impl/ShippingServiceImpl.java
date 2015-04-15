package net.shangtech.eshop.sales.service.impl;

import net.shangtech.eshop.sales.dao.ShippingDao;
import net.shangtech.eshop.sales.entity.Shipping;
import net.shangtech.eshop.sales.service.ShippingService;
import net.shangtech.framework.orm.service.BaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ShippingServiceImpl extends BaseService<Shipping> implements ShippingService {

	@Autowired private ShippingDao dao;

}
