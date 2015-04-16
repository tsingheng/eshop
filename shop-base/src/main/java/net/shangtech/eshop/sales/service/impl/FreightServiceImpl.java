package net.shangtech.eshop.sales.service.impl;

import java.util.List;

import net.shangtech.eshop.sales.command.FreightTemplate;
import net.shangtech.eshop.sales.dao.FreightDao;
import net.shangtech.eshop.sales.entity.Freight;
import net.shangtech.eshop.sales.service.FreightService;
import net.shangtech.framework.orm.service.BaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FreightServiceImpl extends BaseService<Freight> implements FreightService {
	
	@Autowired private FreightDao dao;

	@Override
    public Freight getFreight(Long areaId, Long shippingId) {
	    return dao.getFreight(areaId, shippingId);
    }

	@Override
    public List<FreightTemplate> findByShippingId(Long shippingId) {
	    return dao.findByShippingId(shippingId);
    }

	@Override
    public List<Freight> findByAreaId(Long areaId) {
	    return dao.findByAreaId(areaId);
    }
	
	@Override
	public void save(Freight freight){
		Freight old = dao.getFreight(freight.getAreaId(), freight.getShippingId());
		if(old == null){
			dao.save(freight);
		}else{
			old.setAdditionalPrice(freight.getAdditionalPrice());
			old.setAddtionalUnit(freight.getAddtionalUnit());
			old.setFirstPrice(freight.getFirstPrice());
			old.setFirstWeight(freight.getFirstWeight());
			dao.update(freight);
		}
	}
	
}
