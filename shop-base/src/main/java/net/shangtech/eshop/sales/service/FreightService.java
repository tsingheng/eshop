package net.shangtech.eshop.sales.service;

import java.util.List;

import net.shangtech.eshop.sales.entity.Freight;
import net.shangtech.framework.orm.service.IBaseService;

public interface FreightService extends IBaseService<Freight> {
	
	Freight getFreight(Long areaId, Long shippingId);
	
	List<Freight> findByShippingId(Long shippingId);
	
	List<Freight> findByAreaId(Long areaId);
}
