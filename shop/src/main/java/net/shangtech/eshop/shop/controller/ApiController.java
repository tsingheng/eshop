package net.shangtech.eshop.shop.controller;

import java.util.List;

import net.shangtech.eshop.product.entity.Category;
import net.shangtech.eshop.product.entity.Sku;
import net.shangtech.eshop.product.service.CategoryService;
import net.shangtech.eshop.product.service.SkuService;
import net.shangtech.framework.orm.dao.support.Pagination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApiController {
	
	//private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired private CategoryService categoryService;
	@Autowired private SkuService skuService;
	
	@ResponseBody
	@RequestMapping("/api/product/{id}")
	public Sku loadProduct(@PathVariable("id") Long id){
		return skuService.find(id);
	}
	
	@ResponseBody
	@RequestMapping("/api/product-list")
	public Pagination<Sku> loadProduct(Long categoryId, Pagination<Sku> pagination){
//		return skuService.findByCategory(categoryId, qb, pagination);
		return pagination;
	}
	
	@ResponseBody
	@RequestMapping("/api/all-category")
	public List<Category> loadAllCategory(){
		return categoryService.findAll();
	}
}
