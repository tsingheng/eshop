package net.shangtech.shop.manager.product.controller;

import java.util.List;

import net.shangtech.shop.product.entity.Category;
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
		List<Category> list = service.findByParentId(Category.DEFAULT_PARENT_ID);
		model.addAttribute("list", list);
		return "manager.category.index";
	}
	
	@RequestMapping(value = {"/list", "/list/{parentId}"})
	public String list(Model model, @PathVariable Long parentId){
		List<Category> list = service.findByParentId(parentId);
		model.addAttribute("list", list);
		return "manager.category.list";
	}
	
	@RequestMapping("/save")
	public void save(Category category){
		if(category.getId() == null){
			service.save(category);
		}
		else {
			service.update(category);
		}
	}
}
