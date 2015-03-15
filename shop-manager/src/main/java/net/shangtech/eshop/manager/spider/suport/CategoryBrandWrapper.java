package net.shangtech.eshop.manager.spider.suport;

import net.shangtech.eshop.product.entity.Brand;

public class CategoryBrandWrapper {
	
	private String url;
	
	private Brand brand;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	
}
