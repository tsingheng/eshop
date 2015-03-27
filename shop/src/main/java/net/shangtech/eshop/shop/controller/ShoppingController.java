package net.shangtech.eshop.shop.controller;

import net.shangtech.eshop.product.entity.Inventory;
import net.shangtech.eshop.product.entity.Sku;
import net.shangtech.eshop.product.service.InventoryService;
import net.shangtech.eshop.product.service.SkuService;
import net.shangtech.eshop.sales.service.ShoppingCartItemService;
import net.shangtech.eshop.shop.controller.annotation.Shopwired;
import net.shangtech.eshop.shop.controller.command.LoginMember;
import net.shangtech.eshop.shop.controller.command.ShoppingCartCommand;
import net.shangtech.eshop.shop.controller.command.ShoppingCartItemCommand;
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
	
	@Autowired private 	ShoppingCartItemService 			shoppingCartItemService;
	@Autowired private 	InventoryService 					inventoryService;
	@Autowired private 	SkuService 							skuService;
	
	@Shopwired
	@RequestMapping("/add-to-shopping-cat")
	public AjaxResponse addToShoppingCart(@RequestParam("code") String code, @RequestParam("quantity") Integer quantity
			, ShoppingCartCommand shoppingCart, LoginMember loginMember){
		AjaxResponse ajaxResponse = AjaxResponse.instance();
		//code是否存在
		Inventory inventory = inventoryService.findByCode(code);
		if(inventory == null){
			ajaxResponse.setMessage("商品不存在");
			return ajaxResponse;
		}
		//库存校验
		if(inventory.getStock() <= inventory.getStock()){
			ajaxResponse.setMessage("商品已售完");
			return ajaxResponse;
		}
		//商品状态校验
		Sku sku = skuService.find(inventory.getSkuId());
		
		ShoppingCartItemCommand cmd = new ShoppingCartItemCommand();
		cmd.setSku(sku);
		cmd.setCode(code);
		cmd.setQuantity(quantity);
		cmd.setAvaliable(inventory.getStock() - inventory.getSaled());
		shoppingCart.addItem(cmd);
		
		//如果是已登录用户,将购物车商品存入数据库
		if(loginMember != null){
			shoppingCartItemService.addItem(code, quantity, loginMember.getId());
		}
		
		ajaxResponse.setSuccess(true);
		return ajaxResponse;
	}
}
