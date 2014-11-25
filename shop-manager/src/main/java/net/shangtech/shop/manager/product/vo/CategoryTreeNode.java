package net.shangtech.shop.manager.product.vo;

import java.io.Serializable;
import java.util.List;

import net.shangtech.shop.product.entity.Category;

import org.springframework.beans.BeanUtils;

public class CategoryTreeNode implements Serializable {

	private static final long serialVersionUID = 1599631242195884450L;
	
	private Object id;
	
	@SuppressWarnings("unused")
    private String name;
	
	private Boolean isParent;
	
	private String categoryName;
	
	private String categoryCode;
	
	private Integer priority;
	
	private List<CategoryTreeNode> children;
	
	private Long parentId;

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
	
	public String getName() {
		return categoryName;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getIsParent() {
		return isParent;
	}

	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}

	public List<CategoryTreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<CategoryTreeNode> children) {
		this.children = children;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
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
