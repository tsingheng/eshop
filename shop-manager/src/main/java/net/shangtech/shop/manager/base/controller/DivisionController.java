package net.shangtech.shop.manager.base.controller;

import net.shangtech.shop.basic.service.IDivisionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/devision")
public class DivisionController {
	@Autowired private IDivisionService divisionService;
	@RequestMapping("/index")
	public String index(){
		return "manager.division.index";
	}
}
