package net.shangtech.eshop.shop.controller;

import java.util.List;

import net.shangtech.eshop.product.entity.Category;
import net.shangtech.eshop.product.service.CategoryService;
import net.shangtech.eshop.solr.SolrService;
import net.shangtech.eshop.solr.SolrSku;
import net.shangtech.framework.dao.support.Pagination;

import org.apache.solr.client.solrj.SolrServerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductListController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductListController.class);
	
	@Autowired private CategoryService categoryService;
	@Autowired private SolrService solrService;
	
	@RequestMapping(value = "/cate-{categories}/list", method = RequestMethod.GET)
	public String listByCategory(@PathVariable String categories, Model model, Pagination<SolrSku> pagination){
		String[] categoryCodes = categories.split("-");
		
		Category currentTopCategory = categoryService.findByCode(categoryCodes[0]);
		model.addAttribute("currentTopCategory", currentTopCategory);
		
		//code不是唯一的,需要结合上级id查询
		Category currentCategory = categoryService.findByCodeAndRootId(categoryCodes[categoryCodes.length-1], currentTopCategory.getId());
		model.addAttribute("currentCategory", currentCategory);
		
		List<Category> categoryList = categoryService.findByParentId(currentTopCategory.getId());
		for(Category category : categoryList){
			category.setChildren(categoryService.findByParentId(category.getId()));
		}
		model.addAttribute("categoryList", categoryList);
		
		loadPageByCategory(categories, model, pagination);
		
		return "shop.product.list.category";
	}
	
	@RequestMapping(value = "/cate-{categories}/list", method = RequestMethod.POST)
	public String loadPageByCategory(@PathVariable String categories, Model model, Pagination<SolrSku> pagination){
		
		String[] categoryCodes = categories.split("-");
		
		pagination.setLimit(48);
		try {
	        pagination = solrService.findByCategory(categoryCodes, pagination);
	        model.addAttribute("pagination", pagination);
        } catch (SolrServerException e) {
	        logger.error("solr查询异常", e);
        }
		
		return "shop.product.list.category.page";
	}
	
}
