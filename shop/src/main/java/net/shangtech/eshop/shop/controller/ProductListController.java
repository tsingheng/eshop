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

@Controller
public class ProductListController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductListController.class);
	
	@Autowired private CategoryService categoryService;
	@Autowired private SolrService solrService;
	
	@RequestMapping("/cate-{categories}/list.htm")
	public String listByCategory(@PathVariable String categories, Model model, Pagination<SolrSku> pagination){
		String[] categoryCodes = categories.split("-");
		
		Category currentTopCategory = categoryService.findByCode(categoryCodes[0]);
		model.addAttribute("currentTopCategory", currentTopCategory);
		
		Category currentCategory = categoryService.findByCode(categoryCodes[categoryCodes.length-1]);
		model.addAttribute("currentCategory", currentCategory);
		
		List<Category> topCategoryList = categoryService.findByParentId(Category.ROOT_CATE_ID);
		model.addAttribute("topCategoryList", topCategoryList);
		
		List<Category> categoryList = categoryService.findByParentId(currentTopCategory.getId());
		for(Category category : categoryList){
			category.setChildren(categoryService.findByParentId(category.getId()));
		}
		model.addAttribute("categoryList", categoryList);
		
		pagination.setLimit(48);
		try {
	        pagination = solrService.findByCategory(categoryCodes, pagination);
	        model.addAttribute("pagination", pagination);
        } catch (SolrServerException e) {
	        logger.error("solr查询异常", e);
        }
		
		return "shop.product.list.category";
	}
	
}
