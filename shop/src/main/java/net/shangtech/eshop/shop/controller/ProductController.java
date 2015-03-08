package net.shangtech.eshop.shop.controller;

import java.util.List;

import net.shangtech.eshop.product.dao.qbs.ProductQueryBean;
import net.shangtech.eshop.product.entity.Category;
import net.shangtech.eshop.product.entity.Product;
import net.shangtech.eshop.product.service.ICategoryService;
import net.shangtech.eshop.product.service.IProductService;
import net.shangtech.framework.dao.support.Pagination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductController {
	
	//private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired private ICategoryService categoryService;
	@Autowired private IProductService productService;
	
	@ResponseBody
	@RequestMapping("/api/product/{id}")
	public Product loadProduct(@PathVariable("id") Long id){
		return productService.find(id);
	}
	
	@ResponseBody
	@RequestMapping("/api/product-list")
	public Pagination<Product> loadProduct(Long categoryId, ProductQueryBean qb, Pagination<Product> pagination){
		return productService.findByCategory(categoryId, qb, pagination);
	}
	
	@ResponseBody
	@RequestMapping("/api/all-category")
	public List<Category> loadAllCategory(){
		return categoryService.findAll();
	}
}
