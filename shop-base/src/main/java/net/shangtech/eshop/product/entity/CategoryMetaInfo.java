package net.shangtech.eshop.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import net.shangtech.framework.orm.dao.support.BaseEntity;

import org.hibernate.annotations.Index;

@Entity
@Table(name = "t_category_meta_info")
public class CategoryMetaInfo extends BaseEntity<Long> {

	private static final long serialVersionUID = 6397145202058346242L;

	@Column(name = "category_id")
	@Index(name = "idx_category_meta_info_category_id")
	private Long categoryId;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "keywords")
	private String keywords;
	
	@Column(name = "description")
	private String description;

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
