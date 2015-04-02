package net.shangtech.eshop.product.service;

import java.util.List;

import net.shangtech.eshop.product.entity.Inventory;
import net.shangtech.framework.orm.service.IBaseService;

public interface InventoryService extends IBaseService<Inventory> {
	List<Inventory> findBySkuId(Long skuId);
	
	Inventory findByCode(String code);
}
