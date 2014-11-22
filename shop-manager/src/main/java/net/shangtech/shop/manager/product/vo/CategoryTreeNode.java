package net.shangtech.shop.manager.product.vo;

import java.io.Serializable;

public class CategoryTreeNode implements Serializable {

	private static final long serialVersionUID = 1599631242195884450L;
	
	private Long id;
	
	private String categoryName;
	
	private String categoryCode;
	
	private Integer priority;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	
}
