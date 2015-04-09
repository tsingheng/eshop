package net.shangtech.eshop.shop.controller.aspect;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.shangtech.eshop.product.entity.Inventory;
import net.shangtech.eshop.product.entity.Sku;
import net.shangtech.eshop.product.service.InventoryService;
import net.shangtech.eshop.product.service.SkuService;
import net.shangtech.eshop.shop.constants.ScopConstants.SessionScope;
import net.shangtech.eshop.shop.controller.command.LoginMember;
import net.shangtech.eshop.shop.controller.command.ShoppingCartCommand;
import net.shangtech.eshop.shop.controller.command.ShoppingCartItemCommand;
import net.shangtech.eshop.shop.controller.command.ShoppingCartItemCookie;
import net.shangtech.eshop.shop.controller.command.ShoppingCartSkuCommand;
import net.shangtech.eshop.shop.controller.utils.CookieUtils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.util.WebUtils;

@Aspect
public class ShopwiredAspect {
	
	@Autowired private HttpServletRequest request;
	@Autowired private SkuService skuService;
	@Autowired private InventoryService inventoryService;
	
	@Around("@annotation(net.shangtech.eshop.shop.controller.annotation.Shopwired)")
	public Object shopwired(ProceedingJoinPoint pjp) throws Throwable {
		Object[] args = pjp.getArgs();
		if(args.length == 0){
			return pjp.proceed();
		}
		for(int i = 0; i < args.length; i++){
			Object arg = args[i];
			if (arg instanceof ShoppingCartCommand) {
				args[i] = loadShoppingCart();
			} else if (arg instanceof LoginMember) {
				args[i] = loadLoginMember(); 
			}
		}
		return pjp.proceed(args);
	}
	
	private ShoppingCartCommand loadShoppingCart(){
		ShoppingCartCommand shoppingCart = (ShoppingCartCommand) WebUtils.getSessionAttribute(request, SessionScope.SHOPPING_CART_COMMAND_KEY);
		if(shoppingCart == null){
			shoppingCart = new ShoppingCartCommand();
			shoppingCart.setActualAmount(new BigDecimal(0));
			shoppingCart.setActualFreight(new BigDecimal(0));
			shoppingCart.setOriginalAmount(new BigDecimal(0));
			shoppingCart.setOriginalFreight(new BigDecimal(0));
			shoppingCart.setQuantity(0);
			List<ShoppingCartItemCommand> items = Collections.synchronizedList(new ArrayList<ShoppingCartItemCommand>());
			shoppingCart.setShoppingCartItemList(items);
			loadShoppingCartFromCookie(items);
			shoppingCart.refreshShoppingCart();
			WebUtils.setSessionAttribute(request, SessionScope.SHOPPING_CART_COMMAND_KEY, shoppingCart);
		}
		return shoppingCart;
	}
	
	/**
	 * 从cookie中加载购物车
	 * @param list
	 */
	private void loadShoppingCartFromCookie(List<ShoppingCartItemCommand> list){
		List<ShoppingCartItemCookie> items = CookieUtils.getShoppingCartItems(request);
		if(!CollectionUtils.isEmpty(items)){
			for(ShoppingCartItemCookie item : items){
				ShoppingCartItemCommand cmd = new ShoppingCartItemCommand();
				Inventory inventory = inventoryService.findByCode(item.getCode());
				if(inventory == null){
					continue;
				}
				Sku sku = skuService.find(inventory.getId());
				if(sku == null){
					continue;
				}
				int avaliable = inventory.getStock() - inventory.getStock();
				if(avaliable <= 0){
					continue;
				}
				cmd.setAvaliable(avaliable);
				cmd.setCode(item.getCode());
				cmd.setColor(sku.getColor());
				cmd.setQuantity(item.getQuantity());
				cmd.setSize(inventory.getSize());
				ShoppingCartSkuCommand skuCommand = new ShoppingCartSkuCommand();
				BeanUtils.copyProperties(sku, skuCommand);
				cmd.setSku(skuCommand);
				list.add(cmd);
			}
		}
	}
	
	private LoginMember loadLoginMember(){
		return (LoginMember) WebUtils.getSessionAttribute(request, SessionScope.LOGIN_MEMBER_KEY);
	}
	
}
