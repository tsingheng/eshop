package net.shangtech.shop.product.service.impl;

import net.shangtech.framework.service.BaseService;
import net.shangtech.shop.product.entity.Product;
import net.shangtech.shop.product.service.IProductService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductService extends BaseService<Product> implements IProductService {

}
