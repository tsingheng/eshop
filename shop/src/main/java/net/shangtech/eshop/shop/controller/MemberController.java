package net.shangtech.eshop.shop.controller;

import net.shangtech.eshop.account.service.MemberService;
import net.shangtech.eshop.shop.controller.command.MemberRegisterCommand;
import net.shangtech.framework.controller.AjaxResponse;
import net.shangtech.framework.controller.validation.RequestValid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {
	
	@Autowired private MemberService memberService;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String gotoRegister(){
		return "shop.member.register";
	}
	
	@RequestValid
	@ResponseBody
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public Object register(@RequestValid MemberRegisterCommand cmd){
		AjaxResponse ajaxResponse = AjaxResponse.instance();
		
		ajaxResponse.setData(cmd);
		return ajaxResponse;
	}
}
