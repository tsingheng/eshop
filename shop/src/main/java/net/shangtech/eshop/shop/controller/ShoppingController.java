package net.shangtech.eshop.shop.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.shangtech.eshop.account.entity.MemberAddress;
import net.shangtech.eshop.account.service.MemberAddressService;
import net.shangtech.eshop.product.entity.Inventory;
import net.shangtech.eshop.product.entity.Sku;
import net.shangtech.eshop.product.service.InventoryService;
import net.shangtech.eshop.product.service.SkuService;
import net.shangtech.eshop.sales.service.OrderService;
import net.shangtech.eshop.sales.service.ShoppingCartItemService;
import net.shangtech.eshop.sales.service.bo.OrderBo;
import net.shangtech.eshop.sales.service.bo.OrderItemBo;
import net.shangtech.eshop.shop.controller.annotation.Shopwired;
import net.shangtech.eshop.shop.controller.command.CreateOrderCommand;
import net.shangtech.eshop.shop.controller.command.LoginMember;
import net.shangtech.eshop.shop.controller.command.ShoppingCartCommand;
import net.shangtech.eshop.shop.controller.command.ShoppingCartItemCommand;
import net.shangtech.eshop.shop.controller.command.ShoppingCartSkuCommand;
import net.shangtech.framework.web.controller.AjaxResponse;
import net.shangtech.framework.web.controller.validation.RequestValid;

import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@Autowired private 	MemberAddressService				memberAddressService;
	@Autowired private 	OrderService						orderService;
	
	@Shopwired
	@ResponseBody
	@RequestMapping(value = "/add-to-shopping-cart", method = RequestMethod.POST)
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
		if(inventory.getStock() <= inventory.getSaled()){
			ajaxResponse.setMessage("商品已售完");
			return ajaxResponse;
		}
		//商品状态校验
		Sku sku = skuService.find(inventory.getSkuId());
		
		ShoppingCartItemCommand cmd = new ShoppingCartItemCommand();
		ShoppingCartSkuCommand skuCommand = new ShoppingCartSkuCommand();
		BeanUtils.copyProperties(sku, skuCommand);
		cmd.setSku(skuCommand);
		cmd.setCode(code);
		cmd.setQuantity(quantity);
		cmd.setSize(inventory.getSize());
		cmd.setColor(sku.getColor());
		cmd.setAvaliable(inventory.getStock() - inventory.getSaled());
		shoppingCart.addItem(cmd);
		
		//如果是已登录用户,将购物车商品存入数据库
		if(loginMember != null){
			shoppingCartItemService.addItem(code, quantity, loginMember.getId());
		}
		
		ajaxResponse.setSuccess(true);
		ajaxResponse.setData(shoppingCart);
		return ajaxResponse;
	}
	
	@Shopwired
	@ResponseBody
	@RequestMapping(value = "/reduce-shopping-item", method = RequestMethod.POST)
	public AjaxResponse reduceShoppingItem(@RequestParam("code") String code, @RequestParam("quantity") Integer quantity
			, ShoppingCartCommand shoppingCart, LoginMember loginMember){
		AjaxResponse ajaxResponse = AjaxResponse.instance();
		//code是否存在
		Inventory inventory = inventoryService.findByCode(code);
		if(inventory == null){
			ajaxResponse.setMessage("商品不存在");
			return ajaxResponse;
		}
		shoppingCart.reduceItem(code, quantity);
		
		//如果是已登录用户,同步至数据库
		if(loginMember != null){
			shoppingCartItemService.reduceItem(code, quantity, loginMember.getId());
		}
		
		ajaxResponse.setSuccess(true);
		ajaxResponse.setData(shoppingCart);
		return ajaxResponse;
	}
	
	@Shopwired
	@ResponseBody
	@RequestMapping(value = "/reset-shopping-item", method = RequestMethod.POST)
	public AjaxResponse resetShoppingItem(@RequestParam("code") String code, @RequestParam("quantity") Integer quantity
			, ShoppingCartCommand shoppingCart, LoginMember loginMember){
		AjaxResponse ajaxResponse = AjaxResponse.instance();
		//code是否存在
		Inventory inventory = inventoryService.findByCode(code);
		if(inventory == null){
			ajaxResponse.setMessage("商品不存在");
			return ajaxResponse;
		}
		shoppingCart.resetItem(code, quantity);
		
		if(loginMember != null){
			shoppingCartItemService.updateItem(code, quantity, loginMember.getId());
		}
		ajaxResponse.setSuccess(true);
		ajaxResponse.setData(shoppingCart);
		return ajaxResponse;
	}
	
	@Shopwired
	@ResponseBody
	@RequestMapping(value = "/remove-shopping-item", method = RequestMethod.POST)
	public AjaxResponse removeShoppingItem(@RequestParam("code") String code
			, ShoppingCartCommand shoppingCart, LoginMember loginMember){
		AjaxResponse ajaxResponse = AjaxResponse.instance();
		//code是否存在
		Inventory inventory = inventoryService.findByCode(code);
		if(inventory == null){
			ajaxResponse.setMessage("商品不存在");
			return ajaxResponse;
		}
		shoppingCart.removeItem(code);
		
		if(loginMember != null){
			shoppingCartItemService.removeItem(code, loginMember.getId());
		}
		ajaxResponse.setSuccess(true);
		ajaxResponse.setData(shoppingCart);
		return ajaxResponse;
	}
	
	@Shopwired
	@ResponseBody
	@RequestMapping(value = "/load-shopping-cart", method = RequestMethod.POST)
	public ShoppingCartCommand loadShoppingCart(ShoppingCartCommand shoppingCart){
		//更新cookie中的购物车
		return shoppingCart;
	}
	
	@Shopwired
	@RequestMapping("/shopping-cart")
	public String gotoShoppingCart(Model model, ShoppingCartCommand shoppingCart){
		model.addAttribute("shoppingCart", shoppingCart);
		model.addAttribute("step", 1);
		return "shop.shopping.cart";
	}
	
	@Shopwired
	@RequestMapping("/shopping-checkout")
	public String checkout(Model model, ShoppingCartCommand shoppingCart, LoginMember loginMember){
		model.addAttribute("shoppingCart", shoppingCart);
		
		List<MemberAddress> memberAddressList = null;
		if (loginMember != null) {
	        memberAddressList = memberAddressService.findbyMemberId(loginMember.getId());
	        if(shoppingCart.getMemberAddressId() == null){
	        	for(MemberAddress address : memberAddressList){
	        		if(BooleanUtils.isTrue(address.getIsDefault())){
	        			shoppingCart.setMemberAddressId(address.getId());
	        			break;
	        		}
	        	}
	        }
        } else if (shoppingCart.getMemberAddressId() != null) {
        	memberAddressList = Arrays.asList(memberAddressService.find(shoppingCart.getMemberAddressId()));
        }
		model.addAttribute("memberAddressList", memberAddressList);
		model.addAttribute("loginMember", loginMember);
		model.addAttribute("step", 2);
		
		return "shop.shopping.checkout";
	}
	
	@Shopwired
	@RequestValid
	@ResponseBody
	@RequestMapping("/create-order")
	public AjaxResponse createOrder(@RequestValid CreateOrderCommand cmd, Model model, ShoppingCartCommand shoppingCart, LoginMember loginMember){
		AjaxResponse ajaxResponse = AjaxResponse.instance();
		
		OrderBo order = new OrderBo();
		order.setActualAmount(shoppingCart.getActualAmount().doubleValue());
		order.setActualFreight(shoppingCart.getActualFreight().doubleValue());
		order.setMemberAddressId(shoppingCart.getMemberAddressId());
		order.setOriginalAmount(shoppingCart.getOriginalAmount().doubleValue());
		order.setOriginalFreight(shoppingCart.getOriginalFreight().doubleValue());
		order.setQuantity(shoppingCart.getQuantity());
		order.setMessage(cmd.getMessage());
		if(loginMember != null){
			order.setMemberId(loginMember.getId());
			if(cmd.getMemberAddressId() != null){
				MemberAddress address = memberAddressService.find(cmd.getMemberAddressId());
				if(address != null){
					order.setMemberAddressId(cmd.getMemberAddressId());
				}
			}
		}
		
		List<OrderItemBo> orderItemList = new ArrayList<OrderItemBo>();
		for(ShoppingCartItemCommand item : shoppingCart.getShoppingCartItemList()){
			OrderItemBo orderItem = new OrderItemBo();
			orderItem.setActualAmount(item.getSku().getSellPrice()*item.getQuantity());
			orderItem.setOriginalAmount(item.getSku().getSellPrice()*item.getQuantity());
			orderItem.setInventoryCode(item.getCode());
			orderItem.setPrice(item.getSku().getSellPrice());
			orderItem.setQuantity(item.getQuantity());
			Sku sku = skuService.findByCode(item.getSku().getCode());
			orderItem.setSkuId(sku.getId());
			orderItemList.add(orderItem);
		}
		order.setItems(orderItemList);
		
		orderService.createOrder(order);
		
		return ajaxResponse;
	}
}
