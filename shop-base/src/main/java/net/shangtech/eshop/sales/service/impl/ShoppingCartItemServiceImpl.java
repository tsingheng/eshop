package net.shangtech.eshop.sales.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.shangtech.eshop.sales.dao.ShoppingCartItemDao;
import net.shangtech.eshop.sales.entity.ShoppingCartItem;
import net.shangtech.eshop.sales.service.ShoppingCartItemService;
import net.shangtech.framework.service.BaseService;

@Service
@Transactional
public class ShoppingCartItemServiceImpl extends BaseService<ShoppingCartItem> implements ShoppingCartItemService {
	
	@Autowired private ShoppingCartItemDao dao;
}
