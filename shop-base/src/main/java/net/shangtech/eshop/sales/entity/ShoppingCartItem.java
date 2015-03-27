package net.shangtech.eshop.sales.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Index;

import net.shangtech.framework.dao.support.BaseEntity;

@Entity
@Table(name = "t_shopping_cart_item")
public class ShoppingCartItem extends BaseEntity<Long> {

	private static final long serialVersionUID = -3953349903353760267L;
	
	@Column(name = "member_id")
	@Index(name = "idx_shopping_cart_item_member_id")
	private Long memberId;
	
	@Column(name = "sku_id")
	@Index(name = "idx_shopping_cart_item_sku_id")
	private Long skuId;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "create_time")
	private Date createTime;

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public Long getSkuId() {
		return skuId;
	}

	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
