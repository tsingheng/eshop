package net.shangtech.eshop.sales.service.impl;


import java.util.Date;

import net.shangtech.eshop.sales.dao.ShoppingCartItemDao;
import net.shangtech.eshop.sales.entity.ShoppingCartItem;
import net.shangtech.eshop.sales.service.ShoppingCartItemService;
import net.shangtech.framework.service.BaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ShoppingCartItemServiceImpl extends BaseService<ShoppingCartItem> implements ShoppingCartItemService {
	
	@Autowired private ShoppingCartItemDao dao;

	@Override
    public void addItem(String code, int quantity, Long memberId) {
	    ShoppingCartItem item = dao.findByCodeAndMemberId(code, memberId);
	    if(item != null){
	    	item.setQuantity(item.getQuantity() + quantity);
	    	dao.update(item);
	    }else{
	    	item = new ShoppingCartItem();
	    	item.setCode(code);
	    	item.setCreateTime(new Date());
	    	item.setMemberId(memberId);
	    	item.setQuantity(quantity);
	    	dao.save(item);
	    }
    }

	@Override
    public void reduceItem(String code, int quantity, Long memberId) {
	    ShoppingCartItem item = dao.findByCodeAndMemberId(code, memberId);
	    item.setQuantity(item.getQuantity() - quantity);
	    if(item.getQuantity() < 1){
	    	item.setDeleted(true);
	    	item.setDeleteTime(new Date());
	    }
	    dao.save(item);
    }

	@Override
    public void updateItem(String code, int quantity, Long memberId) {
	    ShoppingCartItem item = dao.findByCodeAndMemberId(code, memberId);
	    item.setQuantity(quantity);
	    dao.update(item);
    }

	@Override
    public void removeItem(String code, Long memberId) {
	    ShoppingCartItem item = dao.findByCodeAndMemberId(code, memberId);
	    item.setDeleted(true);
	    item.setDeleteTime(new Date());
	    dao.update(item);
    }
}
