package net.shangtech.eshop.manager.spider.suport;

import java.util.List;

import net.shangtech.eshop.product.entity.Category;

public class CategoryWrapper {
	private Long id;
    
    private Long parentId;
	
    private Category category;
    
    private Category parent;
    
	private String url;
	
	private List<CategoryWrapper> children;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public List<CategoryWrapper> getChildren() {
		return children;
	}

	public void setChildren(List<CategoryWrapper> children) {
		this.children = children;
	}
	
}
