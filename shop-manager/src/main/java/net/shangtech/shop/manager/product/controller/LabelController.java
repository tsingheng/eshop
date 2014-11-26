package net.shangtech.shop.manager.product.controller;

import net.shangtech.framework.controller.AjaxResponse;
import net.shangtech.framework.dao.support.Pagination;
import net.shangtech.shop.manager.product.vo.LabelQueryBean;
import net.shangtech.shop.product.entity.Label;
import net.shangtech.shop.product.service.ILabelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/label")
public class LabelController {
	
	@Autowired private ILabelService service;
	
	@RequestMapping("/index")
	public String index(){
		return "manager.label.index";
	}
	
	@RequestMapping(value = "/list")
	public Pagination<Label> list(LabelQueryBean queryBean, Pagination<Label> pagination){
		pagination = service.findPage(queryBean, pagination);
		return pagination;
	}
	
	@RequestMapping("/form")
	public String form(@RequestParam(required = false) Long id, Model model){
		if(id != null){
			Label label = service.find(id);
			model.addAttribute("label", label);
		}
		return "manager.label.form";
	}
	
	@ResponseBody
	@RequestMapping("/save")
	public AjaxResponse save(Label label){
		AjaxResponse ajaxResponse = AjaxResponse.instance();
		if(label.getId() == null){
			service.save(label);
		}
		else {
			service.update(label);
		}
		ajaxResponse.setSuccess(true);
		return ajaxResponse;
	}
	
}
