package net.shangtech.eshop.sales.dao;

import java.util.List;

import net.shangtech.eshop.sales.entity.ShoppingCartItem;
import net.shangtech.framework.orm.dao.IBaseDao;

public interface ShoppingCartItemDao extends IBaseDao<ShoppingCartItem> {
	List<ShoppingCartItem> findByMemberId(Long memberId);
	
	ShoppingCartItem findByCodeAndMemberId(String code, Long memberId);
}
