package net.shangtech.eshop.product.service;

import net.shangtech.eshop.product.entity.Brand;
import net.shangtech.framework.service.IBaseService;

public interface BrandService extends IBaseService<Brand> {
	Brand findBySn(String sn);
	Brand findByCode(String code);
}
