package net.shangtech.eshop.product.service.impl;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.shangtech.eshop.product.dao.IProductDao;
import net.shangtech.eshop.product.entity.Product;
import net.shangtech.eshop.product.service.IProductService;
import net.shangtech.framework.service.BaseService;

@Service
@Transactional
public class ProductService extends BaseService<Product> implements IProductService {

	@Autowired private IProductDao dao;
}
