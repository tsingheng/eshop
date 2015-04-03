package net.shangtech.eshop.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.shangtech.eshop.product.dao.CategoryMetaInfoDao;
import net.shangtech.eshop.product.entity.CategoryMetaInfo;
import net.shangtech.eshop.product.service.CategoryMetaInfoService;
import net.shangtech.framework.orm.service.BaseService;

@Service
@Transactional
public class CategoryMetaInfoServiceImpl extends BaseService<CategoryMetaInfo> implements CategoryMetaInfoService {

	@Autowired private CategoryMetaInfoDao dao;
	@Override
	public CategoryMetaInfo findByCategoryId(Long categoryId) {
		return dao.findOneByProperty("categoryId", categoryId);
	}
	
}
