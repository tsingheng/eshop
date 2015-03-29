package net.shangtech.eshop.shop.controller.command;

import java.io.Serializable;

public class ShoppingCartSkuCommand implements Serializable {

    private static final long serialVersionUID = 5976886963693247535L;

    private String code;
    
    private String name;
    
    private String color;
    
    private Integer stock;
    
    private Integer saled;
    
    private Double marketPrice;
    
    private Double sellPrice;

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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Integer getSaled() {
		return saled;
	}

	public void setSaled(Integer saled) {
		this.saled = saled;
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
    
}
