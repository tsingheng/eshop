package net.shangtech.eshop.sales.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Index;

import net.shangtech.framework.orm.dao.support.BaseEntity;

/**
 * 运费
 * @author tsingheng
 *
 */
@Entity
@Table(name = "t_freight")
public class Freight extends BaseEntity<Long> {

    private static final long serialVersionUID = 1732141044639153607L;
	
    /** 国家id */
    @Column(name = "area_id")
    @Index(name = "idx_freight_area_id")
    private Long areaId;
    
    /** 物流方式id */
    @Column(name = "shipping_id")
    @Index(name = "idx_freight_shipping_id")
    private Long shippingId;
    
    /** 首重 */
    @Column(name = "first_weight")
    private Double firstWeight;
    
    /** 首重价格 */
    @Column(name = "first_price")
    private Double firstPrice;
    
    /** 续重价格 */
    @Column(name = "additional_price")
    private Double additionalPrice;
    
    /** 续重单位 */
    @Column(name = "additional_unit")
    private Double additionalUnit;

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public Long getShippingId() {
		return shippingId;
	}

	public void setShippingId(Long shippingId) {
		this.shippingId = shippingId;
	}

	public Double getFirstWeight() {
		return firstWeight;
	}

	public void setFirstWeight(Double firstWeight) {
		this.firstWeight = firstWeight;
	}

	public Double getFirstPrice() {
		return firstPrice;
	}

	public void setFirstPrice(Double firstPrice) {
		this.firstPrice = firstPrice;
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
    
}
