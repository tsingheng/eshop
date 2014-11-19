package net.shangtech.shop.manager.product.controller;

import net.shangtech.shop.product.service.ICategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired private ICategoryService service;
	
	@RequestMapping("/index")
	public String index(Model model){
		
		return "manager.category.index";
	}
	
	@RequestMapping(value = {"/list", "/list/{parentId}"})
	public String list(Model model, @PathVariable Long parentId){
		
		return "manager.category.list";
	}
}
