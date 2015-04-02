package net.shangtech.eshop.manager.controller.product;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import net.shangtech.eshop.manager.controller.product.vo.query.SkuQueryBean;
import net.shangtech.eshop.manager.vo.EasyuiPage;
import net.shangtech.eshop.manager.vo.EasyuiTreeNode;
import net.shangtech.eshop.product.entity.Category;
import net.shangtech.eshop.product.entity.Sku;
import net.shangtech.eshop.product.service.CategoryService;
import net.shangtech.eshop.product.service.SkuService;
import net.shangtech.framework.orm.dao.support.Pagination;
import net.shangtech.framework.web.controller.AjaxResponse;

import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired private CategoryService categoryService;
	@Autowired private SkuService skuService;

	@RequestMapping("")
	public String category(){
		return "manager.category.main";
	}
	
	@RequestMapping("/form")
	public String form(Long id, Long parentId, Model model){
		Category category = null;
		if(id != null){
			category = categoryService.find(id);
			parentId = category.getParentId();
		}
		model.addAttribute("category", category);
		
		if(parentId != null){
			model.addAttribute("parent", categoryService.find(parentId));
		}
		return "manager.category.form";
	}
	
	@ResponseBody
	@RequestMapping("/save")
	public AjaxResponse save(@Valid Category category, BindingResult result){
		AjaxResponse ajaxResponse = AjaxResponse.instance();
		Date now = new Date(System.currentTimeMillis());
		category.setVersion(now);
		if(category.getId() == null){
			category.setCreateTime(now);
			categoryService.save(category);
		}else{
			categoryService.update(category);
		}
		EasyuiTreeNode node = new EasyuiTreeNode();
		node.setId(category.getId());
		node.setParentId(category.getParentId());
		node.setText(category.getName());
		ajaxResponse.setData(node);
		ajaxResponse.setSuccess(true);
		return ajaxResponse;
	}
	
	@ResponseBody
	@RequestMapping("/remove")
	public AjaxResponse remove(Integer id){
		AjaxResponse ajaxResponse = AjaxResponse.instance();
		categoryService.delete(id);
		ajaxResponse.setSuccess(true);
		return ajaxResponse;
	}
	
	@ResponseBody
	@RequestMapping("/cate-tree")
	public List<EasyuiTreeNode> categoryTree(){
		List<Category> categories = categoryService.findAll();
		Map<Long, EasyuiTreeNode> map = new HashMap<Long, EasyuiTreeNode>();
		List<EasyuiTreeNode> list = new ArrayList<EasyuiTreeNode>();
		for(Category category : categories){
			EasyuiTreeNode node = new EasyuiTreeNode();
			node.setChildren(new ArrayList<EasyuiTreeNode>());
			node.setId(category.getId());
			node.setParentId(category.getParentId());
			node.setText(category.getName());
			if(!BooleanUtils.isTrue(category.getLeaf())){
				node.setState(EasyuiTreeNode.NODE_STATE_CLOSED);
			}
			map.put(node.getId(), node);
			if(Category.ROOT_CATE_ID.equals(category.getParentId())){
				list.add(node);
			}
		}
		for(Category category : categories){
			EasyuiTreeNode parent = map.get(category.getParentId());
			if(parent != null){
				parent.getChildren().add(map.get(category.getId()));
			}
		}
		return list;
	}
	
	@ResponseBody
	@RequestMapping("/products")
	public EasyuiPage<Sku> products(Long categoryId, SkuQueryBean qb, Pagination<Sku> pagination){
		if(categoryId != null){
			List<Category> categories = categoryService.findWithChildren(categoryId);
			List<Long> categoryIds = new ArrayList<Long>(categories.size());
			for(Category category : categories){
				categoryIds.add(category.getId());
			}
			qb.setCategoryIds(categoryIds);
		}
		pagination = skuService.findPage(qb, pagination);
		EasyuiPage<Sku> page = new EasyuiPage<Sku>();
		page.setTotal(pagination.getTotalCount());
		page.setRows(pagination.getItems());
		return page;
	}
}
