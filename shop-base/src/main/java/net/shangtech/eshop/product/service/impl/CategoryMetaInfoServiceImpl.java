package net.shangtech.eshop.product.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.shangtech.eshop.product.entity.CategoryMetaInfo;
import net.shangtech.eshop.product.service.CategoryMetaInfoService;
import net.shangtech.framework.orm.service.BaseService;

@Service
@Transactional
public class CategoryMetaInfoServiceImpl extends BaseService<CategoryMetaInfo> implements CategoryMetaInfoService {
	
}
