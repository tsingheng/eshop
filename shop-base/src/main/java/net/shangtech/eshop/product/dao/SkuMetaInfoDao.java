package net.shangtech.eshop.product.dao;

import net.shangtech.eshop.product.entity.SkuMetaInfo;
import net.shangtech.framework.orm.dao.IBaseDao;

public interface SkuMetaInfoDao extends IBaseDao<SkuMetaInfo> {
	SkuMetaInfo findBySkuId(Long skuId);
}
