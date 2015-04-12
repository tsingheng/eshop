package net.shangtech.eshop.shop.controller;

import java.util.List;

import net.shangtech.eshop.product.entity.Category;
import net.shangtech.eshop.product.entity.CategoryMetaInfo;
import net.shangtech.eshop.product.service.CategoryMetaInfoService;
import net.shangtech.eshop.product.service.CategoryService;
import net.shangtech.eshop.shop.constants.ShopConstants;
import net.shangtech.eshop.solr.SolrService;
import net.shangtech.eshop.solr.SolrSku;
import net.shangtech.framework.orm.dao.support.Pagination;

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
	
	@Autowired private CategoryService 				categoryService;
	@Autowired private SolrService 					solrService;
	@Autowired private CategoryMetaInfoService		categoryMetaInfoService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listByCategory(Model model, Pagination<SolrSku> pagination){
		return doListByCategory(model, pagination);
	}
	
	@RequestMapping(value = "/{c1}/list", method = RequestMethod.GET)
	public String listByCategory(@PathVariable String c1, Model model, Pagination<SolrSku> pagination){
		return doListByCategory(model, pagination, c1);
	}
	
	@RequestMapping(value = "/{c1}/{c2}/list", method = RequestMethod.GET)
	public String listByCategory(@PathVariable String c1, @PathVariable String c2, Model model, Pagination<SolrSku> pagination){
		return doListByCategory(model, pagination, c1, c2);
	}
	
	@RequestMapping(value = "/{c1}/{c2}/{c3}/list", method = RequestMethod.GET)
	public String listByCategory(@PathVariable String c1, @PathVariable String c2, @PathVariable String c3, Model model, Pagination<SolrSku> pagination){
		return doListByCategory(model, pagination, c1, c2, c3);
	}
	
	private String doListByCategory(Model model, Pagination<SolrSku> pagination, String... categoryCodes){
		if(categoryCodes != null && categoryCodes.length > 0){
			Category currentTopCategory = categoryService.findByCode(categoryCodes[0]);
			model.addAttribute("currentTopCategory", currentTopCategory);
			
			//code不是唯一的,需要结合上级id查询
			Category currentCategory = currentTopCategory;
			if(categoryCodes.length > 1){
				currentCategory = categoryService.findByCodeAndRootId(categoryCodes[categoryCodes.length-1], currentTopCategory.getId());
			}
			model.addAttribute("currentCategory", currentCategory);
			CategoryMetaInfo metaInfo = categoryMetaInfoService.findByCategoryId(currentCategory.getId());
			if(metaInfo != null){
				model.addAttribute(ShopConstants.META_INFO_KEYWORDS_KEY, metaInfo.getKeywords());
				model.addAttribute(ShopConstants.META_INFO_DESCRIPTION_KEY, metaInfo.getDescription());
			}
		
			List<Category> categoryList = categoryService.findByParentId(currentTopCategory.getId());
			for(Category category : categoryList){
				category.setChildren(categoryService.findByParentId(category.getId()));
			}
			model.addAttribute("categoryList", categoryList);
		}
		
		doLoadPageByCategory(model, pagination, categoryCodes);
		
		return "shop.product.list.category";
	}
	
	private String doLoadPageByCategory(Model model, Pagination<SolrSku> pagination, String... categoryCodes){
		
		pagination.setLimit(40);
		try {
	        pagination = solrService.findByCategory(categoryCodes, pagination);
	        model.addAttribute("pagination", pagination);
        } catch (SolrServerException e) {
	        logger.error("solr查询异常", e);
        }
		
		return "shop.product.list.category.page";
	}
	
}
