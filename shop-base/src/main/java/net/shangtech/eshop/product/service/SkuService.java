package net.shangtech.eshop.product.service;

import java.util.List;

import net.shangtech.eshop.product.entity.Sku;
import net.shangtech.framework.orm.service.IBaseService;

public interface SkuService extends IBaseService<Sku> {
	
	Sku findByVid(String vid);
	
	Sku findByCode(String code);
	
	List<Sku> findByCategoryId(Long categoryId, Integer size);
}
