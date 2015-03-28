package net.shangtech.eshop.shop.controller.aspect;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.shangtech.eshop.shop.constants.ScopConstants.SessionScope;
import net.shangtech.eshop.shop.controller.command.LoginMember;
import net.shangtech.eshop.shop.controller.command.ShoppingCartCommand;
import net.shangtech.eshop.shop.controller.command.ShoppingCartItemCommand;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.util.WebUtils;

@Aspect
public class ShopwiredAspect {
	
	//这个我测试过是线程安全的,还不知道为什么
	@Autowired private HttpServletRequest request;
	
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
			List<ShoppingCartItemCommand> items = new ArrayList<ShoppingCartItemCommand>();
			shoppingCart.setShoppingCartItemList(Collections.synchronizedList(items));
			WebUtils.setSessionAttribute(request, SessionScope.SHOPPING_CART_COMMAND_KEY, shoppingCart);
		}
		return shoppingCart;
	}
	
	private LoginMember loadLoginMember(){
		return (LoginMember) WebUtils.getSessionAttribute(request, SessionScope.LOGIN_MEMBER_KEY);
	}
	
}
