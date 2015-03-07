package net.shangtech.eshop.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.shangtech.eshop.product.dao.IInventoryDao;
import net.shangtech.eshop.product.entity.Inventory;
import net.shangtech.eshop.product.service.IInventoryService;
import net.shangtech.framework.service.BaseService;

@Service
@Transactional
public class InventoryService extends BaseService<Inventory> implements IInventoryService {

	@Autowired private IInventoryDao dao;
}
