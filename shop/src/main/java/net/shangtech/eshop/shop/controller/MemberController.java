package net.shangtech.eshop.shop.controller;

import net.shangtech.eshop.account.entity.Member;
import net.shangtech.eshop.account.service.MemberService;
import net.shangtech.eshop.shop.controller.command.MemberLoginCommand;
import net.shangtech.eshop.shop.controller.command.MemberRegisterCommand;
import net.shangtech.framework.controller.AjaxResponse;
import net.shangtech.framework.controller.validation.RequestValid;
import net.shangtech.framework.util.EncoderUtils;

import org.apache.commons.lang3.StringUtils;
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
	public AjaxResponse register(@RequestValid MemberRegisterCommand cmd){
		AjaxResponse ajaxResponse = AjaxResponse.instance();
		//验证码
		
		cmd.setEmail(StringUtils.lowerCase(cmd.getEmail()));
		
		Member old = memberService.findByEmail(cmd.getEmail());
		if(old != null){
			//邮箱已被占用
			ajaxResponse.addError("email", "邮箱已被占用");
			return ajaxResponse;
		}
		
		Member member = new Member();
		member.setEmail(cmd.getEmail());
		member.setGender(cmd.getGender());
		member.setPasswrod(EncoderUtils.MD5(cmd.getEmail()));
		memberService.save(member);
		
		//auto login
		
		return ajaxResponse;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String gotoLogin(){
		return "shop.member.login";
	}
	
	public AjaxResponse login(@RequestValid MemberLoginCommand cmd){
		AjaxResponse ajaxResponse = AjaxResponse.instance();
		//验证码
		
		cmd.setUsername(StringUtils.lowerCase(cmd.getUsername()));
		
		Member member = memberService.findByEmail(cmd.getUsername());
		if(member == null){
			member = memberService.findByMobile(cmd.getUsername());
		}
		if(member == null || !StringUtils.equals(member.getPasswrod(), EncoderUtils.MD5(cmd.getPassword()))){
			ajaxResponse.addError("password", "用户名和密码不匹配");
			return ajaxResponse;
		}
		return ajaxResponse;
	}
}
