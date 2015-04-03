package net.shangtech.eshop.shop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.shangtech.eshop.account.entity.Member;
import net.shangtech.eshop.account.entity.MemberAddress;
import net.shangtech.eshop.account.service.MemberAddressService;
import net.shangtech.eshop.account.service.MemberService;
import net.shangtech.eshop.product.entity.Inventory;
import net.shangtech.eshop.product.entity.Sku;
import net.shangtech.eshop.product.service.InventoryService;
import net.shangtech.eshop.product.service.SkuService;
import net.shangtech.eshop.sales.entity.ShoppingCartItem;
import net.shangtech.eshop.sales.service.ShoppingCartItemService;
import net.shangtech.eshop.shop.constants.ScopConstants.SessionScope;
import net.shangtech.eshop.shop.controller.annotation.Shopwired;
import net.shangtech.eshop.shop.controller.command.LoginMember;
import net.shangtech.eshop.shop.controller.command.MemberAddressCommand;
import net.shangtech.eshop.shop.controller.command.MemberLoginCommand;
import net.shangtech.eshop.shop.controller.command.MemberRegisterCommand;
import net.shangtech.eshop.shop.controller.command.ShoppingCartCommand;
import net.shangtech.eshop.shop.controller.command.ShoppingCartItemCommand;
import net.shangtech.eshop.shop.controller.command.ShoppingCartSkuCommand;
import net.shangtech.framework.util.EncoderUtils;
import net.shangtech.framework.web.controller.AjaxResponse;
import net.shangtech.framework.web.controller.validation.RequestValid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {
	
	@Autowired private MemberService 				memberService;
	@Autowired private MemberAddressService 		memberAddressService;
	@Autowired private HttpServletRequest 			request;
	@Autowired private ShoppingCartItemService 		shoppingCartItemService;
	@Autowired private InventoryService 			inventoryService;
	@Autowired private SkuService 					skuService;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String gotoRegister(){
		return "shop.member.register";
	}
	
	@RequestValid
	@ResponseBody
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public AjaxResponse register(@RequestValid MemberRegisterCommand cmd, HttpSession session){
		AjaxResponse ajaxResponse = AjaxResponse.instance();
		//验证码
		String captchaInSession = (String) session.getAttribute(SessionScope.CAPTCHA_KEY);
		if(!StringUtils.equalsIgnoreCase(captchaInSession, cmd.getCaptcha())){
			ajaxResponse.addError("captcha", "验证码错误");
			return ajaxResponse;
		}
		
		//邮箱一律转成小写
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
		member.setPasswrod(EncoderUtils.MD5(cmd.getPass().getPassword()));
		memberService.save(member);
		
		//auto login
		
		return ajaxResponse;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String gotoLogin(){
		return "shop.member.login";
	}
	
	@Shopwired
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public AjaxResponse login(@RequestValid MemberLoginCommand cmd, ShoppingCartCommand shoppingCart, HttpSession session){
		AjaxResponse ajaxResponse = AjaxResponse.instance();
		//验证码
		String captchaInSession = (String) session.getAttribute(SessionScope.CAPTCHA_KEY);
		if(!StringUtils.equalsIgnoreCase(captchaInSession, cmd.getCaptcha())){
			ajaxResponse.addError("captcha", "验证码错误");
			return ajaxResponse;
		}
		
		cmd.setUsername(StringUtils.lowerCase(cmd.getUsername()));
		
		Member member = memberService.findByEmail(cmd.getUsername());
		if(member == null){
			member = memberService.findByMobile(cmd.getUsername());
		}
		if(member == null || !StringUtils.equals(member.getPasswrod(), EncoderUtils.MD5(cmd.getPassword()))){
			ajaxResponse.addError("password", "用户名和密码不匹配");
			return ajaxResponse;
		}
		
		LoginMember loginMember = new LoginMember();
		loginMember.setId(member.getId());
		loginMember.setUsername(cmd.getUsername());
		session.setAttribute(SessionScope.LOGIN_MEMBER_KEY, loginMember);
		
		mergeShoppingCart(shoppingCart, loginMember);
		
		return ajaxResponse;
	}
	
	/**
	 * 合并数据库和session中的shoppingCart
	 * @param shoppingCart
	 * @param loginMember
	 */
	private void mergeShoppingCart(ShoppingCartCommand shoppingCart, LoginMember loginMember){
		//清理数据库中的购物车
		List<ShoppingCartItem> shoppingCartItems = shoppingCartItemService.findByMemberId(loginMember.getId());
		List<ShoppingCartItemCommand> validItems = new ArrayList<ShoppingCartItemCommand>();
		for(ShoppingCartItem item : shoppingCartItems){
			Inventory inventory = inventoryService.findByCode(item.getCode());
			if(inventory == null){
				shoppingCartItemService.removeItem(item.getCode(), loginMember.getId());
			}
			int avaliable = inventory.getStock() - inventory.getSaled();
			Sku sku = skuService.find(inventory.getSkuId());
			if(avaliable <= 0 || sku == null){
				shoppingCartItemService.removeItem(item.getCode(), loginMember.getId());
			}
			ShoppingCartItemCommand itemCommand = new ShoppingCartItemCommand();
			itemCommand.setAvaliable(avaliable);
			itemCommand.setCode(inventory.getCode());
			itemCommand.setColor(sku.getColor());
			itemCommand.setQuantity(item.getQuantity());
			itemCommand.setSize(inventory.getSize());
			ShoppingCartSkuCommand skuCommand = new ShoppingCartSkuCommand();
			BeanUtils.copyProperties(sku, skuCommand);
			itemCommand.setSku(skuCommand);
			validItems.add(itemCommand);
		}
		//将session中的购物车合并到数据库中
		if(!CollectionUtils.isEmpty(shoppingCart.getShoppingCartItemList())){
			for(ShoppingCartItemCommand item : shoppingCart.getShoppingCartItemList()){
				shoppingCartItemService.addItem(item.getCode(), item.getQuantity(), loginMember.getId());
			}
		}
		//将数据库中有效数据合并至session购物车中
		for(ShoppingCartItemCommand item : validItems){
			shoppingCart.addItem(item);
		}
	}
	
	@Shopwired
	@RequestValid
	@ResponseBody
	@RequestMapping(value = "/save-address", method = RequestMethod.POST)
	public AjaxResponse saveMemberAddress(@RequestValid MemberAddressCommand addressCommand, ShoppingCartCommand shoppingCart, LoginMember loginMember){
		AjaxResponse ajaxResponse = AjaxResponse.instance();
		
		MemberAddress memberAddress = new MemberAddress();
		BeanUtils.copyProperties(addressCommand, memberAddress);
		
		//如果是未登录用户,只允许有一条地址
		if(loginMember == null && shoppingCart.getMemberAddressId() != null){
			memberAddress.setId(shoppingCart.getMemberAddressId());
		}
		if(memberAddress.getId() == null){
			if(loginMember == null){
				memberAddress.setMemberId(Member.GUEST_MEMBER_ID);
			}else{
				memberAddress.setMemberId(loginMember.getId());
			}
			memberAddressService.save(memberAddress);
		}else{
			MemberAddress old = memberAddressService.find(memberAddress.getId());
			if(old == null || (loginMember != null && old.getMemberId() != loginMember.getId())){
				ajaxResponse.setMessage("不存在该地址");
				return ajaxResponse;
			}
			memberAddressService.update(memberAddress);
		}
		shoppingCart.setMemberAddressId(memberAddress.getId());
		
		BeanUtils.copyProperties(memberAddress, addressCommand);
		ajaxResponse.setData(addressCommand);
		ajaxResponse.setSuccess(true);
		
		return ajaxResponse;
	}
	
	@Shopwired
	@ResponseBody
	@RequestMapping(value = "/deleve-address", method = RequestMethod.POST)
	public AjaxResponse deleteMemberAddress(@RequestParam("addressId") Long addressId, LoginMember loginMember){
		AjaxResponse ajaxResponse = AjaxResponse.instance();
		if(loginMember == null){
			ajaxResponse.setMessage("请先登录");
			return ajaxResponse;
		}
		MemberAddress old = memberAddressService.find(addressId);
		if(old == null || old.getMemberId() != loginMember.getId()){
			ajaxResponse.setMessage("不存在该地址");
			return ajaxResponse;
		}
		memberAddressService.delete(addressId);
		ajaxResponse.setSuccess(true);
		return ajaxResponse;
	}
}
