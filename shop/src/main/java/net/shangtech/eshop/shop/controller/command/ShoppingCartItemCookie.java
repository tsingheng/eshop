package net.shangtech.eshop.shop.controller.command;

import java.io.Serializable;

/**
 * 存放在cookie中的购物车信息
 * @author tsingheng
 *
 */
public class ShoppingCartItemCookie implements Serializable {
	
    private static final long serialVersionUID = 4591623782191303352L;

	private String code;
	
	private int quantity;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
