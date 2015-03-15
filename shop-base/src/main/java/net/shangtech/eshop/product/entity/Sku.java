package net.shangtech.eshop.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.Index;

import net.shangtech.framework.dao.support.BaseEntity;

@Entity
@Table(name = "t_sku")
public class Sku extends BaseEntity<Long> {
	
    private static final long serialVersionUID = -6634884131249457163L;
    
    @Column(name = "pro_name")
	private String name;
	
    @Column(name = "sku_code")
	@Index(name = "idx_sku_code")
	private String code;
	
	private String image;
	
	@Column(name = "market_price")
	private Double marketPrice;
	
	@Column(name = "sell_price")
	private Double sellPrice;
	
	@Column(name = "color")
	private String color;
	
	@Column(name = "brand_id")
	@Index(name = "idx_sku_brand_id")
	private Long brandId;
	
	@Column(name = "brand_code")
	private String brandCode;
	
	@Column(name = "category_id")
	@Index(name = "idx_sku_category_id")
	private Long categoryId;
	
	@Column(name = "status")
	private String status;
	
	@Lob
	@Column(name = "images")
	private String images;
	
	@Lob
	@Column(name = "content")
	private String content;
	
	@Column(name = "vid")
	@Index(name = "idx_sku_vid")
	private String vid;
	
	@Column(name = "colors")
	private String colors;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	public Double getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(Double marketPrice) {
		this.marketPrice = marketPrice;
	}

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

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

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

	public String getBrandCode() {
		return brandCode;
	}

	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getVid() {
		return vid;
	}

	public void setVid(String vid) {
		this.vid = vid;
	}

	public String getColors() {
		return colors;
	}

	public void setColors(String colors) {
		this.colors = colors;
	}
	
}
