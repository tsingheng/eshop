package net.shangtech.shop.manager.base.controller;

import java.util.List;

import net.shangtech.shop.basic.entity.Division;
import net.shangtech.shop.basic.entity.DivisionProperty;
import net.shangtech.shop.basic.service.IDivisionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/devision")
public class DivisionController {
	
	@Autowired private IDivisionService divisionService;
	
	@RequestMapping("/index")
	public String index(){
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
	
	@RequestMapping("/save")
	public void saveDivision(Division division){
		divisionService.update(division);
	}
	
	@RequestMapping("/properties/save")
	public void saveDivisionProperties(List<DivisionProperty> properties, Division division){
		
	}
}
