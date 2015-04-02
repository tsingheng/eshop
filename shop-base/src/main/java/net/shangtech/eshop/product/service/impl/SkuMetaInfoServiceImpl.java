package net.shangtech.eshop.product.service.impl;

import net.shangtech.eshop.product.dao.SkuMetaInfoDao;
import net.shangtech.eshop.product.entity.SkuMetaInfo;
import net.shangtech.eshop.product.service.SkuMetaInfoService;
import net.shangtech.framework.orm.service.BaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SkuMetaInfoServiceImpl extends BaseService<SkuMetaInfo> implements SkuMetaInfoService {

	@Autowired private SkuMetaInfoDao dao;
	
	@Override
	public SkuMetaInfo findBySkuId(Long skuId) {
		return dao.findBySkuId(skuId);
	}

}
