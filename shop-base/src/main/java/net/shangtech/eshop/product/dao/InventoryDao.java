package net.shangtech.eshop.product.dao;

import java.util.List;

import net.shangtech.eshop.product.entity.Inventory;
import net.shangtech.framework.dao.IBaseDao;

public interface InventoryDao extends IBaseDao<Inventory> {
	List<Inventory> findBySkuId(Long skuId);
	
	Inventory findByCode(String code);
}
