package net.shangtech.eshop.shop.controller;

import java.util.List;

import net.shangtech.eshop.product.entity.Category;
import net.shangtech.eshop.product.service.CategoryService;
import net.shangtech.eshop.solr.SolrService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductListController {
	
	@Autowired private CategoryService categoryService;
	@Autowired private SolrService solrService;
	
	@RequestMapping("/cate-{categoies}.htm")
	public String listByCategory(@PathVariable String categories, Model model){
		String[] categoryCodes = categories.split("-");
		
		Category currentTopCategory = categoryService.findByCode(categoryCodes[0]);
		model.addAttribute("currentTopCategory", currentTopCategory);
		
		List<Category> categoryList = categoryService.findByParentId(currentTopCategory.getId());
		for(Category category : categoryList){
			category.setChildren(categoryService.findByParentId(category.getId()));
		}
		model.addAttribute("categoryList", categoryList);
		
		
		
		return "shop.product.list.category";
	}
	
}
