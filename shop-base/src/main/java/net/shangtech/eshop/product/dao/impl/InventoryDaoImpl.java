package net.shangtech.eshop.product.dao.impl;

import java.util.List;

import net.shangtech.eshop.product.dao.InventoryDao;
import net.shangtech.eshop.product.entity.Inventory;
import net.shangtech.framework.orm.dao.hibernate.BaseDao;

import org.springframework.stereotype.Repository;

@Repository
public class InventoryDaoImpl extends BaseDao<Inventory> implements InventoryDao {

	@Override
    public List<Inventory> findBySkuId(Long skuId) {
	    return findByProperty("skuId", skuId);
    }

	@Override
    public Inventory findByCode(String code) {
	    return findOneByProperty("code", code);
    }

}
