package net.shangtech.shop.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import net.shangtech.framework.dao.support.BaseEntity;

@Entity
@Table(name = "t_category")
public class Category extends BaseEntity<Long> {

	private static final long serialVersionUID = 3136298768139532432L;
	
	public static final Long DEFAULT_PARENT_ID = 0L;
	
	@Column(name = "cate_name")
	private String categoryName;
	
	@Column(name = "cate_code")
	private String categoryCode;
	
	@Column(name = "parent_id")
	private Long parentId;
	
	@Column(name = "priority")
	private Integer priority;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

}
