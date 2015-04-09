package net.shangtech.eshop.shop.controller.command;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

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
	
	/**
	 * 向购物车中添加商品
	 * @param item
	 */
	public void addItem(ShoppingCartItemCommand cmd){
		boolean hasInShoppingCart = false;
		for(ShoppingCartItemCommand item : shoppingCartItemList){
			if(StringUtils.equalsIgnoreCase(item.getCode(), cmd.getCode())){
				hasInShoppingCart = true;
				item.add(cmd.getQuantity());
				break;
			}
		}
		if(!hasInShoppingCart){
			shoppingCartItemList.add(cmd);
		}
		refreshShoppingCart();
	}
	
	/**
	 * 将商品移出购物车
	 * @param code
	 */
	public void removeItem(String code){
		Iterator<ShoppingCartItemCommand> it = shoppingCartItemList.iterator();
		while(it.hasNext()){
			ShoppingCartItemCommand item = it.next();
			if(StringUtils.equalsIgnoreCase(item.getCode(), code)){
				it.remove();
				break;
			}
		}
		refreshShoppingCart();
	}
	
	/**
	 * 减少购物车中商品的数量
	 * @param code
	 */
	public void reduceItem(String code, int quantity){
		Iterator<ShoppingCartItemCommand> it = shoppingCartItemList.iterator();
		while(it.hasNext()){
			ShoppingCartItemCommand item = it.next();
			if(StringUtils.equalsIgnoreCase(item.getCode(), code)){
				item.reduce(quantity);
				if(item.getQuantity() == 0){
					it.remove();
				}
				break;
			}
		}
		refreshShoppingCart();
	}
	
	/** 手动设置购物车中商品的数量 */
	public void resetItem(String code, int quantity){
		Iterator<ShoppingCartItemCommand> it = shoppingCartItemList.iterator();
		while(it.hasNext()){
			ShoppingCartItemCommand item = it.next();
			if(StringUtils.equalsIgnoreCase(item.getCode(), code)){
				item.setQuantity(quantity);
				break;
			}
		}
		refreshShoppingCart();
	}
	
	/**
	 * 刷新购物车属性
	 */
	public void refreshShoppingCart(){
		int quantity = 0;
		BigDecimal originalAmount = new BigDecimal(0);
		BigDecimal actualAmount = new BigDecimal(0);
		for(ShoppingCartItemCommand item : shoppingCartItemList){
			quantity += item.getQuantity();
			originalAmount = originalAmount.add(new BigDecimal(item.getSku().getMarketPrice()*item.getQuantity()));
			actualAmount = actualAmount.add(new BigDecimal(item.getSku().getSellPrice()*item.getQuantity()));
		}
		this.quantity = quantity;
		this.originalAmount = originalAmount;
		this.actualAmount = actualAmount;
	}
}
