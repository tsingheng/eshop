package net.shangtech.eshop.sales.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import net.shangtech.framework.orm.dao.support.BaseEntity;

import org.hibernate.annotations.Index;

@Entity
@Table(name = "t_shopping_cart_item")
public class ShoppingCartItem extends BaseEntity<Long> {

	private static final long serialVersionUID = -3953349903353760267L;
	
	@Column(name = "member_id")
	@Index(name = "idx_shopping_cart_item_member_id")
	private Long memberId;
	
	@Column(name = "inventory_code")
	@Index(name = "idx_shopping_cart_item_code")
	private String code;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "create_time")
	private Date createTime;
	
	@Column(name = "deleted")
	private Boolean deleted = false;
	
	@Column(name = "delete_time")
	private Date deleteTime;

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public Date getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(Date deleteTime) {
		this.deleteTime = deleteTime;
	}
	
}
