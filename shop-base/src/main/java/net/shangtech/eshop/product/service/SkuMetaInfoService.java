package net.shangtech.eshop.product.service;

import net.shangtech.eshop.product.entity.SkuMetaInfo;
import net.shangtech.framework.orm.service.IBaseService;

public interface SkuMetaInfoService extends IBaseService<SkuMetaInfo> {
	SkuMetaInfo findBySkuId(Long skuId);
}
