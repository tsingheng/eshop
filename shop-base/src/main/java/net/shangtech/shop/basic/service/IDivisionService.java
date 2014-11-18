package net.shangtech.shop.basic.service;

import java.util.List;

import net.shangtech.framework.service.IBaseService;
import net.shangtech.shop.basic.entity.Division;
import net.shangtech.shop.basic.entity.DivisionProperty;
import net.shangtech.shop.basic.entity.DivisionPropertyValue;

public interface IDivisionService extends IBaseService<Division> {
	void save(List<DivisionProperty> properties, Division division);
	
	List<Division> findByParentId(Long parentId);
	
	List<DivisionProperty> findDivisionPropertiesByDivisionId(Long divisionId);
	
	List<DivisionPropertyValue> findDivisionPropertyValuesByDivisionPropertyId(Long divisionPropertyId);;
}
