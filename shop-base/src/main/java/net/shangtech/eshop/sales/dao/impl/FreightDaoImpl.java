package net.shangtech.eshop.sales.dao.impl;

import java.util.List;

import net.shangtech.eshop.sales.command.FreightTemplate;
import net.shangtech.eshop.sales.dao.FreightDao;
import net.shangtech.eshop.sales.entity.Freight;
import net.shangtech.framework.orm.dao.hibernate.BaseDao;
import net.shangtech.framework.orm.dao.support.MapHolder;
import net.shangtech.framework.orm.dao.support.Pagination;

import org.springframework.stereotype.Repository;

@Repository
public class FreightDaoImpl extends BaseDao<Freight> implements FreightDao {

	@Override
    public Freight getFreight(Long areaId, Long shippingId) {
		MapHolder<String> holder = new MapHolder<String>();
		holder.put("areaId", areaId);
		holder.put("shippingId", shippingId);
	    return findOneByProperties(holder);
    }

	@Override
    public List<FreightTemplate> findByShippingId(Long shippingId) {
		MapHolder<String> holder = new MapHolder<String>();
		holder.put("shippingId", shippingId);
		Pagination<FreightTemplate> pagination = new Pagination<FreightTemplate>();
		super.findBySql("FreightTemplate.findByShippingId", holder, pagination, FreightTemplate.class);
	    return super.findBySql("FreightTemplate.findByShippingId", holder, FreightTemplate.class);
    }

	@Override
    public List<Freight> findByAreaId(Long areaId) {
	    return findByProperty("areaId", areaId);
    }

	@Override
    public Freight findByAreaIdAndShippingId(Long areaId, Long shippingId) {
		MapHolder<String> holder = new MapHolder<String>();
		holder.put("areaId", areaId);
		holder.put("shippingId", shippingId);
	    return findOneByProperties(holder);
    }

}
