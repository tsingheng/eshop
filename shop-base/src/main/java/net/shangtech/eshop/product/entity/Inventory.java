package net.shangtech.eshop.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import net.shangtech.framework.orm.dao.support.BaseEntity;

import org.hibernate.annotations.Index;

@Entity
@Table(name = "t_sku_inventory")
public class Inventory extends BaseEntity<Long> {

    private static final long serialVersionUID = -2144851727124676913L;
	
    @Column(name = "sku_id")
    @Index(name = "idx_sku_inventory_sku_id")
    private Long skuId;
    
    @Column(name = "size")
    private String size;
    
    @Column(name = "color")
    private String color;
    
    @Column(name = "code")
	@Index(name = "idx_sku_inventory_code")
    private String code;
    
    private Integer stock;
    
    private Integer saled;
    
    @Column(name = "num_min")
    private Integer min;
    
    @Column(name = "num_max")
    private Integer max;

	public Long getSkuId() {
		return skuId;
	}

	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Integer getSaled() {
		return saled;
	}

	public void setSaled(Integer saled) {
		this.saled = saled;
	}

	public Integer getMin() {
		return min;
	}

	public void setMin(Integer min) {
		this.min = min;
	}

	public Integer getMax() {
		return max;
	}

	public void setMax(Integer max) {
		this.max = max;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
    
}
