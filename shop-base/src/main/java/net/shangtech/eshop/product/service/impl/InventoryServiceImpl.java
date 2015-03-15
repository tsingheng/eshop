package net.shangtech.eshop.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.shangtech.eshop.product.dao.InventoryDao;
import net.shangtech.eshop.product.entity.Inventory;
import net.shangtech.eshop.product.service.InventoryService;
import net.shangtech.framework.service.BaseService;

@Service
@Transactional
public class InventoryServiceImpl extends BaseService<Inventory> implements InventoryService {

	@Autowired private InventoryDao dao;

	@Override
    public List<Inventory> findBySkuId(Long skuId) {
	    return dao.findBySkuId(skuId);
    }
}
