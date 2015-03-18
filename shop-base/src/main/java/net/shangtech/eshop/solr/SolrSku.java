package net.shangtech.eshop.solr;

import java.io.Serializable;
import java.util.List;

import org.apache.solr.client.solrj.beans.Field;

public class SolrSku implements Serializable {
	
    private static final long serialVersionUID = -8909953262651976646L;
    
    @Field("id")
	private Long id;
	
    @Field("code")
	private String code;
	
    @Field("name")
	private String name;
	
    @Field("brandCode")
	private String brandCode;
	
    @Field("brandName")
	private String brandName;
	
    @Field("marketPrice")
	private Double marketPrice;
	
    @Field("sellPrice")
	private Double sellPrice;
	
    @Field("sizes")
	private List<String> sizes;
	
    @Field("categories")
	private List<String> categories;
    
    @Field("categoryCodes")
    private List<String> categoryCodes;
    
    @Field("image")
    private String image;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrandCode() {
		return brandCode;
	}

	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
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

	public List<String> getSizes() {
		return sizes;
	}

	public void setSizes(List<String> sizes) {
		this.sizes = sizes;
	}

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	public List<String> getCategoryCodes() {
		return categoryCodes;
	}

	public void setCategoryCodes(List<String> categoryCodes) {
		this.categoryCodes = categoryCodes;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
}
