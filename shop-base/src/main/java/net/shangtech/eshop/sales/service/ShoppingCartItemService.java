package net.shangtech.eshop.sales.service;

import java.util.List;

import net.shangtech.eshop.sales.entity.ShoppingCartItem;
import net.shangtech.framework.orm.service.IBaseService;

public interface ShoppingCartItemService extends IBaseService<ShoppingCartItem> {
	/**
	 * 向购物车添加商品
	 * @param code
	 * @param quantiry
	 * @param memberId
	 */
	void addItem(String code, int quantity, Long memberId);
	
	/**
	 * 减少商品数量
	 * @param code
	 * @param quantity
	 * @param memberId
	 */
	void reduceItem(String code, int quantity, Long memberId);
	
	/**
	 * 更新商品数量
	 * @param code
	 * @param quantity
	 * @param memberId
	 */
	void updateItem(String code, int quantity, Long memberId);
	
	/**
	 * 移除商品
	 * @param code
	 * @param memberId
	 */
	void removeItem(String code, Long memberId);
	
	List<ShoppingCartItem> findByMemberId(Long memberId);
}
