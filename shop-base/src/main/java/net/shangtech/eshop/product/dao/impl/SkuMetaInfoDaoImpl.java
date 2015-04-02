package net.shangtech.eshop.product.dao.impl;

import net.shangtech.eshop.product.dao.SkuMetaInfoDao;
import net.shangtech.eshop.product.entity.SkuMetaInfo;
import net.shangtech.framework.orm.dao.hibernate.BaseDao;

import org.springframework.stereotype.Repository;

@Repository
public class SkuMetaInfoDaoImpl extends BaseDao<SkuMetaInfo> implements SkuMetaInfoDao {

	@Override
	public SkuMetaInfo findBySkuId(Long skuId) {
		return findOneByProperty("skuId", skuId);
	}

}
