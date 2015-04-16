package net.shangtech.eshop.sales.command;

import java.io.Serializable;

import javax.persistence.Column;

public class FreightTemplate implements Serializable {

	private static final long serialVersionUID = -7564006996793633737L;
	
	@Column(name = "area_id")
	private Number areaId;
	
	@Column(name = "freight_id")
	private Number freightId;
	
	@Column(name = "area_name")
	private String areaName;
	
	@Column(name = "additional_price")
	private Double additionalPrice;
	
	@Column(name = "additional_unit")
	private Double additionalUnit;
	
	@Column(name = "first_price")
	private Double firstPrice;
	
	@Column(name = "first_weight")
	private Double firstWeight;

	public Number getAreaId() {
		return areaId;
	}

	public void setAreaId(Number areaId) {
		this.areaId = areaId;
	}

	public Number getFreightId() {
		return freightId;
	}

	public void setFreightId(Number freightId) {
		this.freightId = freightId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public Double getAdditionalPrice() {
		return additionalPrice;
	}

	public void setAdditionalPrice(Double additionalPrice) {
		this.additionalPrice = additionalPrice;
	}

	public Double getAdditionalUnit() {
		return additionalUnit;
	}

	public void setAdditionalUnit(Double additionalUnit) {
		this.additionalUnit = additionalUnit;
	}

	public Double getFirstPrice() {
		return firstPrice;
	}

	public void setFirstPrice(Double firstPrice) {
		this.firstPrice = firstPrice;
	}

	public Double getFirstWeight() {
		return firstWeight;
	}

	public void setFirstWeight(Double firstWeight) {
		this.firstWeight = firstWeight;
	}
	
}
