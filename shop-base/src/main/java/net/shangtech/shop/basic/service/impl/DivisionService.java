package net.shangtech.shop.basic.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import net.shangtech.framework.dao.support.BaseEntity;
import net.shangtech.framework.dao.support.MapHolder;
import net.shangtech.framework.service.BaseService;
import net.shangtech.shop.basic.dao.IDivisionDao;
import net.shangtech.shop.basic.dao.IDivisionPropertyDao;
import net.shangtech.shop.basic.dao.IDivisionPropertyValueDao;
import net.shangtech.shop.basic.entity.Division;
import net.shangtech.shop.basic.entity.DivisionProperty;
import net.shangtech.shop.basic.entity.DivisionPropertyValue;
import net.shangtech.shop.basic.service.IDivisionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

@Service
@Transactional
public class DivisionService extends BaseService<Division> implements IDivisionService {
	@Autowired private IDivisionDao dao;
	@Autowired private IDivisionPropertyDao propertyDao;
	@Autowired private IDivisionPropertyValueDao propertyValueDao;

	@Override
    public List<Division> findByParentId(Long parentId) {
		if(parentId == null){
			parentId = Division.DEFAULT_PARENT_ID;
		}
	    return dao.findByProperties(MapHolder.instance("parentId", parentId));
    }

	@Override
    public List<DivisionProperty> findDivisionPropertiesByDivisionId(Long divisionId) {
		Assert.notNull(divisionId, "can not find division properties by null");
	    return propertyDao.findByProperties(MapHolder.instance("divisionId", divisionId), BaseEntity.ORDER_BY_SORT);
    }

	@Override
    public List<DivisionPropertyValue> findDivisionPropertyValuesByDivisionPropertyId(Long divisionPropertyId) {
	    Assert.notNull(divisionPropertyId, "can not find division property value by null");
		return propertyValueDao.findByProperties(MapHolder.instance("divisionPropertyId", divisionPropertyId), BaseEntity.ORDER_BY_SORT);
    }
	
	@Override
	public void save(Division division){
		Assert.notNull(division, "can not save null");
		if(division.getId() == null) {
			if(division.getParentId() == null){
				division.setParentId(Division.DEFAULT_PARENT_ID);
			}
			dao.save(division);
		}
		else {
			Division old = dao.find(division.getId());
			if(old != null){
				old.setDivisionName(division.getDivisionName());
				dao.update(old);
			}
		}
	}

	@Override
    public void save(List<DivisionProperty> properties, Division division) {
	    Assert.notNull(division, "division can not be null");
	    if(division.getId() == null){
	    	if(division.getParentId() == null){
				division.setParentId(Division.DEFAULT_PARENT_ID);
			}
	    	dao.save(division);
	    }
	    else{
	    	Division old = dao.find(division.getId());
	    	if(old != null){
	    		old.setDivisionName(division.getDivisionName());
	    		dao.update(old);
	    		
	    		// clear old properties and values
	    		List<DivisionProperty> oldProperties = propertyDao.findByDivisionId(division.getId());
	    		for(DivisionProperty property : oldProperties){
	    			propertyValueDao.deleteByDivisionPropertyId(property.getId());
	    		}
	    		propertyDao.deleteByDivisionId(division.getId());
	    	}
	    }
	    if(!CollectionUtils.isEmpty(properties)){
    		for(DivisionProperty property : properties){
    			property.setDivisionId(division.getId());
    			propertyDao.save(property);
    			if(!CollectionUtils.isEmpty(property.getValues())){
    				for(DivisionPropertyValue value : property.getValues()){
    					value.setPropertyId(property.getId());
    					propertyValueDao.save(value);
    				}
    			}
    		}
    	}
    }
}
