package net.shangtech.shop.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import net.shangtech.framework.dao.support.BaseEntity;

@Entity
@Table(name = "t_product_to_category")
public class ProductToCategory extends BaseEntity<Long> {

	private static final long serialVersionUID = 7303858762324834440L;
	
	@Column(name = "product_id")
	private Long productId;
	
	@Column(name = "category_id")
	private Long categoryId;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	
}
