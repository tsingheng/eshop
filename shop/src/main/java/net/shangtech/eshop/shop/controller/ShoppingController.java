package net.shangtech.eshop.shop.controller;

import javax.servlet.http.HttpServletRequest;

import net.shangtech.eshop.sales.service.ShoppingCartItemService;
import net.shangtech.eshop.shop.controller.annotation.Shopwired;
import net.shangtech.eshop.shop.controller.command.LoginMember;
import net.shangtech.eshop.shop.controller.command.ShoppingCartCommand;
import net.shangtech.framework.controller.AjaxResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 购物相关
 * @author 
 *
 */
@Controller
public class ShoppingController {
	
	@Autowired private ShoppingCartItemService shoppingCartItemService;
	
	@Shopwired
	@RequestMapping("/add-to-shopping-cat")
	public AjaxResponse addToShoppingCart(@RequestParam("code") String code, @RequestParam("quantity") String quantity
			, ShoppingCartCommand shoppingCart, LoginMember loginMember){
		AjaxResponse ajaxResponse = AjaxResponse.instance();
		
		return ajaxResponse;
	}
}
