package net.shangtech.eshop.manager.spider.suport;

import java.util.List;

import net.shangtech.eshop.product.entity.Inventory;
import net.shangtech.eshop.product.entity.Sku;

public class ProductWrapper {
	
	private static final String PRODUCT_DETAIL_URL = "http://www.vip.com/detail-000-{id}.html";
	
	private Sku product;
	
	private List<Inventory> inventories;
	
	private String url;

	public Sku getProduct() {
		return product;
	}

	public void setProduct(Sku product) {
		this.product = product;
	}

	public List<Inventory> getInventories() {
		return inventories;
	}

	public void setInventories(List<Inventory> inventories) {
		this.inventories = inventories;
	}
	
	public String getDetailUrl(){
		return PRODUCT_DETAIL_URL.replace("{id}", product.getVid());
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
