package net.shangtech.eshop.product.service;

import net.shangtech.eshop.product.entity.Sku;
import net.shangtech.framework.service.IBaseService;

public interface SkuService extends IBaseService<Sku> {
	
	Sku findByVid(String vid);
	
	Sku findByCode(String code);
}
