package net.shangtech.eshop.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Index;

import net.shangtech.framework.dao.support.BaseEntity;

@Entity
@Table(name = "t_product")
public class Product extends BaseEntity<Long> {
	
    private static final long serialVersionUID = -6634884131249457163L;
    
	private String name;
	
	private String code;
	
	private String image;
	
	private Double marketPrice;
	
	private Double sellPrice;
	
	private String color;
	
	private Long brandId;
	
	private String brandCode;
	
	private Long categoryId;
	
	private String status;

	@Column(name = "pro_name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "pro_code")
	@Index(name = "idx_product_code")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name = "market_price")
	public Double getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(Double marketPrice) {
		this.marketPrice = marketPrice;
	}

	@Column(name = "sell_price")
	public Double getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(Double sellPrice) {
		this.sellPrice = sellPrice;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Column(name = "brand_id")
	@Index(name = "idx_product_brand_id")
	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	@Column(name = "category_id")
	@Index(name = "idx_product_category_id")
	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "brand_code")
	public String getBrandCode() {
		return brandCode;
	}

	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}
	
}
