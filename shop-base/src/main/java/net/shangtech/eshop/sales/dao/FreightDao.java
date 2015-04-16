package net.shangtech.eshop.sales.dao;

import java.util.List;

import net.shangtech.eshop.sales.command.FreightTemplate;
import net.shangtech.eshop.sales.entity.Freight;
import net.shangtech.framework.orm.dao.IBaseDao;

public interface FreightDao extends IBaseDao<Freight> {
	Freight getFreight(Long areaId, Long shippingId);
	List<FreightTemplate> findByShippingId(Long shippingId);
	List<Freight> findByAreaId(Long areaId);
}
