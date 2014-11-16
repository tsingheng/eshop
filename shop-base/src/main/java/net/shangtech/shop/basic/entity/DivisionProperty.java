package net.shangtech.shop.basic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import net.shangtech.framework.dao.support.BaseEntity;

@Entity
@Table(name = "t_pro_division_property")
public class DivisionProperty extends BaseEntity<Long> {

    private static final long serialVersionUID = -7502194000369938341L;

    @Column(name = "division_id")
    private Long divisionId;
    
    @Column(name = "property_name")
    private String propertyName;
    
    @Column(name = "property_type")
    private String propertyType;
    
    @Column(name = "default_value")
    private String defaultValue;
    
    private Integer sort;

	public Long getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(Long divisionId) {
		this.divisionId = divisionId;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
    
}
