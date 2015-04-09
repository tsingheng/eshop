package net.shangtech.eshop.shop.controller;

import net.shangtech.eshop.solr.SolrService;
import net.shangtech.eshop.solr.SolrSku;
import net.shangtech.framework.orm.dao.support.Pagination;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	@Autowired private SolrService solrService;
	
	@RequestMapping(value = {"", "/index"})
	public String index(Model model, Pagination<SolrSku> pagination){
		
		pagination.setLimit(48);
//		try {
//	        //pagination = solrService.findByCategory(new String[]{}, pagination);
//	        model.addAttribute("pagination", pagination);
//        } catch (SolrServerException e) {
//	        logger.error("solr查询异常", e);
//        }
		
		return "shop.index";
	}
	
}
