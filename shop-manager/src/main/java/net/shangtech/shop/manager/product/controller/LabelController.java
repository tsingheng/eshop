package net.shangtech.shop.manager.product.controller;

import net.shangtech.framework.dao.support.Pagination;
import net.shangtech.shop.product.entity.Label;
import net.shangtech.shop.product.service.ILabelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/label")
public class LabelController {
	
	@Autowired private ILabelService service;
	
	@RequestMapping("/index")
	public String index(){
		return "manager.label.index";
	}
	
	@RequestMapping(value = "/list{page}")
	public Pagination<Label> list(@PathVariable Integer page, Pagination<Label> pagination){
		
		return pagination;
	}
	
}
