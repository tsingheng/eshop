package net.shangtech.eshop.shop.controller.command;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class ShoppingCartCommand implements Serializable {

	private static final long serialVersionUID = -3836762802228075322L;

	private List<ShoppingCartItemCommand> shoppingCartItemList;
	
	private int quantity;
	
	private BigDecimal originalAmount;
	
	private BigDecimal actualAmount;
	
	private BigDecimal originalFreight;
	
	private BigDecimal actualFreight;
	
	private Long memberAddressId;

	public List<ShoppingCartItemCommand> getShoppingCartItemList() {
		return shoppingCartItemList;
	}

	public void setShoppingCartItemList(
			List<ShoppingCartItemCommand> shoppingCartItemList) {
		this.shoppingCartItemList = shoppingCartItemList;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getOriginalAmount() {
		return originalAmount;
	}

	public void setOriginalAmount(BigDecimal originalAmount) {
		this.originalAmount = originalAmount;
	}

	public BigDecimal getActualAmount() {
		return actualAmount;
	}

	public void setActualAmount(BigDecimal actualAmount) {
		this.actualAmount = actualAmount;
	}

	public BigDecimal getOriginalFreight() {
		return originalFreight;
	}

	public void setOriginalFreight(BigDecimal originalFreight) {
		this.originalFreight = originalFreight;
	}

	public BigDecimal getActualFreight() {
		return actualFreight;
	}

	public void setActualFreight(BigDecimal actualFreight) {
		this.actualFreight = actualFreight;
	}

	public Long getMemberAddressId() {
		return memberAddressId;
	}

	public void setMemberAddressId(Long memberAddressId) {
		this.memberAddressId = memberAddressId;
	}
	
}
