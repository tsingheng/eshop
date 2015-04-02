package net.shangtech.eshop.sales.dao.impl;

import java.util.List;

import net.shangtech.eshop.sales.dao.ShoppingCartItemDao;
import net.shangtech.eshop.sales.entity.ShoppingCartItem;
import net.shangtech.framework.orm.dao.hibernate.BaseDao;
import net.shangtech.framework.orm.dao.support.MapHolder;

import org.springframework.stereotype.Repository;

@Repository
public class ShoppingCartItemDaoImpl extends BaseDao<ShoppingCartItem> implements ShoppingCartItemDao {

	@Override
    public List<ShoppingCartItem> findByMemberId(Long memberId) {
		MapHolder<String> holder = new MapHolder<String>();
		holder.put("memberId", memberId);
		holder.put("deleted", false);
	    return findByProperties(holder);
    }

	@Override
    public ShoppingCartItem findByCodeAndMemberId(String code, Long memberId) {
		MapHolder<String> holder = new MapHolder<String>();
		holder.put("memberId", memberId);
		holder.put("deleted", false);
		holder.put("code", code);
	    return findOneByProperties(holder);
    }

}
