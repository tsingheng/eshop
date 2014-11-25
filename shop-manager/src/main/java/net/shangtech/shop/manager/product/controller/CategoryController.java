package net.shangtech.shop.manager.product.controller;

import java.util.ArrayList;
import java.util.List;

import net.shangtech.shop.manager.product.vo.CategoryTreeNode;
import net.shangtech.shop.product.entity.Category;
import net.shangtech.shop.product.service.ICategoryService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired private ICategoryService service;
	
	@RequestMapping("/index")
	public String index(){
		return "manager.category.index";
	}
	
	@ResponseBody
	@RequestMapping(value = "/list")
	public List<CategoryTreeNode> list(Model model, @RequestParam(required = false) Long parentId){
		List<Category> list = service.findByParentId(parentId);
		List<CategoryTreeNode> nodes = new ArrayList<>();
		list.forEach(category -> {
			CategoryTreeNode node = new CategoryTreeNode();
			BeanUtils.copyProperties(category, node);
			node.setIsParent(service.hasChildren(category.getId()));
			nodes.add(node);
		});
		return nodes;
	}
	
	@ResponseBody
	@RequestMapping("/save")
	public CategoryTreeNode save(Category category){
		if(category.getId() == null){
			service.save(category);
		}
		else {
			service.update(category);
		}
		CategoryTreeNode node = new CategoryTreeNode();
		BeanUtils.copyProperties(category, node);
		return node;
	}
}
