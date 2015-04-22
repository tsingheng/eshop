package net.shangtech.eshop.product.service.impl;

import java.util.List;

import net.shangtech.eshop.product.dao.SkuPriceDao;
import net.shangtech.eshop.product.entity.SkuPrice;
import net.shangtech.eshop.product.service.SkuPriceService;
import net.shangtech.framework.orm.service.BaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SkuPriceServiceImpl extends BaseService<SkuPrice> implements SkuPriceService {

	@Autowired private SkuPriceDao dao;

	@Override
    public SkuPrice getPrice(Long skuId, int quantity) {
	    return dao.getPrice(skuId, quantity);
    }

	@Override
    public List<SkuPrice> getPriceList(Long skuId) {
	    return dao.getPriceList(skuId);
    }

	@Override
    public SkuPrice getFirstPrice(Long skuId) {
	    return dao.getFirstPrice(skuId);
    }
	
}
