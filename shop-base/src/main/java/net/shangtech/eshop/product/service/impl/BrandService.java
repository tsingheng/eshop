package net.shangtech.eshop.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.shangtech.eshop.product.dao.IBrandDao;
import net.shangtech.eshop.product.entity.Brand;
import net.shangtech.eshop.product.service.IBrandService;
import net.shangtech.framework.service.BaseService;

@Service
@Transactional
public class BrandService extends BaseService<Brand> implements IBrandService {
	
	@Autowired private IBrandDao dao;

	@Override
    public Brand findBySn(String sn) {
	    return dao.findBySn(sn);
    }

	@Override
    public Brand findByCode(String code) {
	    return dao.findByCode(code);
    }
}
