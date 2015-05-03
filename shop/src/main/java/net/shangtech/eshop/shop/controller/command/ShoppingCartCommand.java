package net.shangtech.eshop.shop.controller.command;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import net.shangtech.eshop.account.entity.MemberAddress;
import net.shangtech.eshop.account.service.MemberAddressService;
import net.shangtech.eshop.product.entity.SkuPrice;
import net.shangtech.eshop.product.service.SkuPriceService;
import net.shangtech.eshop.sales.entity.Freight;
import net.shangtech.eshop.sales.service.FreightService;
import net.shangtech.framework.util.SpringUtils;

import org.apache.commons.lang3.StringUtils;

public class ShoppingCartCommand implements Serializable {

	private static final long serialVersionUID = -3836762802228075322L;
	
	private MemberAddressService memberAddressService;
	
	private FreightService freightService;

	private List<ShoppingCartItemCommand> shoppingCartItemList;
	
	private int quantity;
	
	private BigDecimal originalAmount;
	
	private BigDecimal actualAmount;
	
	private BigDecimal originalFreight;
	
	private BigDecimal actualFreight;
	
	private Double weight;
	
	private Long memberAddressId;
	
	private Long shippingId;
	
	private BigDecimal subtotal;

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
				refreshSkuPrice(item);
				break;
			}
		}
		if(!hasInShoppingCart){
			shoppingCartItemList.add(cmd);
			SkuPriceService skuPriceService = SpringUtils.getBean(SkuPriceService.class);
			SkuPrice firstPrice = skuPriceService.getFirstPrice(cmd.getSku().getId());
			cmd.setMin(firstPrice.getMin());
			refreshSkuPrice(cmd);
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
				}else{
					refreshSkuPrice(item);
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
				refreshSkuPrice(item);
				break;
			}
		}
		refreshShoppingCart();
	}
	
	private void refreshSkuPrice(ShoppingCartItemCommand item){
		SkuPriceService skuPriceService = SpringUtils.getBean(SkuPriceService.class);
		SkuPrice skuPrice = skuPriceService.getPrice(item.getSku().getId(), item.getQuantity());
		item.setPrice(skuPrice.getPrice());
	}
	
	public void refreshPrice(){
		for(ShoppingCartItemCommand item : shoppingCartItemList){
			refreshSkuPrice(item);
		}
		refreshShoppingCart();
	}
	
	/**
	 * 刷新购物车属性
	 */
	public void refreshShoppingCart(){
		int quantity = 0;
		Double originalAmount = 0.0;
		Double actualAmount = 0.0;
		Double subtotal = 0.0;
		Double weight = 0.0;
		for(ShoppingCartItemCommand item : shoppingCartItemList){
			quantity += item.getQuantity();
			double amount = item.getPrice()*item.getQuantity();
			item.setAmount(amount);
			subtotal = subtotal + amount;
			weight = weight + item.getSku().getWeight()*item.getQuantity();
		}
		this.weight = weight;
		this.quantity = quantity;
		if(originalFreight != null){
			originalAmount += subtotal.doubleValue();
		}
		if(actualFreight != null){
			actualAmount += subtotal.doubleValue();
		}
		this.subtotal = new BigDecimal(subtotal);
		this.originalAmount = new BigDecimal(originalAmount);
		this.actualAmount = new BigDecimal(actualAmount);
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Long getShippingId() {
		return shippingId;
	}

	public void setShippingId(Long shippingId) {
		if(this.getMemberAddressId() != null){
			MemberAddress memberAddress = memberAddressService.find(this.getMemberAddressId());
			Freight freightTemplate = freightService.findByAreaIdAndShippingId(memberAddress.getAreaId(), shippingId);
			if(freightTemplate != null){
				this.shippingId = shippingId;
				this.originalFreight = new BigDecimal(FreightCommand.calc(freightTemplate, weight));
				this.actualFreight = new BigDecimal(originalFreight.doubleValue());
			}
		}
	}

	public void setMemberAddressService(MemberAddressService memberAddressService) {
		this.memberAddressService = memberAddressService;
	}

	public void setFreightService(FreightService freightService) {
		this.freightService = freightService;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}
	
}
