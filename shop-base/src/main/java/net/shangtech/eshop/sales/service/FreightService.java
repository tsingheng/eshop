package net.shangtech.eshop.sales.service;

import java.util.List;

import net.shangtech.eshop.sales.command.FreightTemplate;
import net.shangtech.eshop.sales.entity.Freight;
import net.shangtech.framework.orm.service.IBaseService;

public interface FreightService extends IBaseService<Freight> {
	
	Freight getFreight(Long areaId, Long shippingId);
	
	List<FreightTemplate> findByShippingId(Long shippingId);
	
	List<Freight> findByAreaId(Long areaId);
	
	Freight findByAreaIdAndShippingId(Long areaId, Long shippingId);
}
