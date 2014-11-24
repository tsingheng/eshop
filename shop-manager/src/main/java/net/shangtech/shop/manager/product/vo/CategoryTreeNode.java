package net.shangtech.shop.manager.product.vo;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;

import net.shangtech.shop.product.entity.Category;

public class CategoryTreeNode implements Serializable {

	private static final long serialVersionUID = 1599631242195884450L;
	
	private Object id;
	
	private String categoryName;
	
	private String categoryCode;
	
	private Integer priority;

	public Object getId() {
		return id;
	}

	public void setId(Object id) {
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
	
	public static void main(String[] args){
		Category category = new Category();
		category.setId(1L);
		category.setCategoryName("aa");
		
		CategoryTreeNode node = new CategoryTreeNode();
		BeanUtils.copyProperties(category, node);
		System.out.println(node.getId());
		System.out.println(node.getCategoryName());
		
	}
	
}
