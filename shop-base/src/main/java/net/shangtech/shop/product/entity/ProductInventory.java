package net.shangtech.shop.product.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import net.shangtech.framework.dao.support.BaseEntity;

@Entity
@Table(name = "t_product_inventory")
public class ProductInventory extends BaseEntity<Long> {

	private static final long serialVersionUID = 3346689497049030235L;

	@Column(name = "product_id")
	private Long productId;
	
	private String color;
	
	private String size;
	
	@Column(name = "avaliable_qty")
	private Integer avaliableQuantity;
	
	@Column(name = "create_time")
	private Date createTime;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Integer getAvaliableQuantity() {
		return avaliableQuantity;
	}

	public void setAvaliableQuantity(Integer avaliableQuantity) {
		this.avaliableQuantity = avaliableQuantity;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
