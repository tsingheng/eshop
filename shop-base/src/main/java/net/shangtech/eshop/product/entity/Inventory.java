package net.shangtech.eshop.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Index;

import net.shangtech.framework.dao.support.BaseEntity;

@Entity
@Table(name = "t_pro_inventory")
public class Inventory extends BaseEntity<Long> {

    private static final long serialVersionUID = -2144851727124676913L;
	
    private Long productId;
    
    private String size;
    
    private String code;
    
    private Integer stock;
    
    private Integer saled;
    
    private Integer min;
    
    private Integer max;

    @Column(name = "product_id")
    @Index(name = "idx_pro_inventory_product_id")
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	@Column(name = "pro_size")
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Column(name = "code")
	@Index(name = "idx_pro_inventory_code")
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

	@Column(name = "num_min")
	public Integer getMin() {
		return min;
	}

	public void setMin(Integer min) {
		this.min = min;
	}

	@Column(name = "num_max")
	public Integer getMax() {
		return max;
	}

	public void setMax(Integer max) {
		this.max = max;
	}
    
}
