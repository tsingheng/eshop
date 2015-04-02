package net.shangtech.eshop.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import net.shangtech.framework.orm.dao.support.BaseEntity;

import org.hibernate.annotations.Index;

@Entity
@Table(name = "t_sku_meta_info")
public class SkuMetaInfo extends BaseEntity<Long> {

	private static final long serialVersionUID = 8717737257833348436L;
	
	@Column(name = "sku_id")
	@Index(name = "idx_sku_meta_info_sku_id")
	private Long skuId;
	
	@Column(name = "keywords")
	private String keywords;
	
	@Column(name = "description")
	private String description;

	public Long getSkuId() {
		return skuId;
	}

	public void setSkuId(Long skuId) {
		this.skuId = skuId;
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
