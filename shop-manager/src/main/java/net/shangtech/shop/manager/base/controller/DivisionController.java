package net.shangtech.shop.manager.base.controller;

import java.util.List;

import net.shangtech.framework.controller.AjaxResponse;
import net.shangtech.shop.basic.entity.Division;
import net.shangtech.shop.basic.entity.DivisionProperty;
import net.shangtech.shop.basic.service.IDivisionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/division")
public class DivisionController {
	
	@Autowired private IDivisionService divisionService;
	
	@RequestMapping("/index")
	public String index(Model model){
		List<Division> list = divisionService.findByParentId(Division.DEFAULT_PARENT_ID);
		model.addAttribute("list", list);
		return "manager.division.index";
	}
	
	@RequestMapping(value = {"/list", "/list/{parentId}"})
	public String list(Model model, @PathVariable Long parentId){
		List<Division> list = divisionService.findByParentId(parentId);
		model.addAttribute("list", list);
		return "manager.division.list";
	}
	
	@RequestMapping(value = {"/create", "/edit/{id}"})
	public String edit(Model model, @PathVariable Long id){
		if(id != null){
			Division division = divisionService.find(id);
			if(division != null){
				model.addAttribute("division", division);
				List<DivisionProperty> properties = divisionService.findDivisionPropertiesByDivisionId(id);
				if(!CollectionUtils.isEmpty(properties)){
					for(DivisionProperty property : properties){
						property.setValues(divisionService.findDivisionPropertyValuesByDivisionPropertyId(property.getId()));
					}
				}
				model.addAttribute("properties", properties);
			}
		}
		return "manager.division.form";
	}
	
	@ResponseBody
	@RequestMapping("/save")
	public AjaxResponse saveDivision(Division division){
		AjaxResponse ajaxResponse = AjaxResponse.instance();
		divisionService.save(division);
		ajaxResponse.setSuccess(true);
		return ajaxResponse;
	}
	
	@ResponseBody
	@RequestMapping("/properties/save")
	public AjaxResponse saveDivisionProperties(List<DivisionProperty> properties, Division division){
		AjaxResponse ajaxResponse = AjaxResponse.instance();
		divisionService.save(properties, division);
		ajaxResponse.setSuccess(true);
		return ajaxResponse;
	}
}
