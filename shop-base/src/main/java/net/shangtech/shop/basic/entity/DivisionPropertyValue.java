package net.shangtech.shop.basic.entity;

import javax.persistence.Column;

import net.shangtech.framework.dao.support.BaseEntity;

public class DivisionPropertyValue extends BaseEntity<Long> {

    private static final long serialVersionUID = -8689905813129802837L;
    
    @Column(name = "property_id")
    private Long propertyId;
    
    @Column(name = "property_value")
    private String propertyValue;
    
    private Integer sort;

	public Long getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(Long propertyId) {
		this.propertyId = propertyId;
	}

	public String getPropertyValue() {
		return propertyValue;
	}

	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
}
