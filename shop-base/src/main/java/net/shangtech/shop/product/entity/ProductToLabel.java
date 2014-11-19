package net.shangtech.shop.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import net.shangtech.framework.dao.support.BaseEntity;

@Entity
@Table(name = "t_product_to_label")
public class ProductToLabel extends BaseEntity<Long> {

	private static final long serialVersionUID = -2111606739246565996L;

	@Column(name = "product_id")
	private Long productId;
	
	@Column(name = "label_id")
	private Long labelId;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getLabelId() {
		return labelId;
	}

	public void setLabelId(Long labelId) {
		this.labelId = labelId;
	}
	
}
