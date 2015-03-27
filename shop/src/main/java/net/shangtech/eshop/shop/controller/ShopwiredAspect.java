package net.shangtech.eshop.shop.controller;

import javax.servlet.http.HttpServletRequest;

import net.shangtech.eshop.shop.constants.ScopConstants.SessionScope;
import net.shangtech.eshop.shop.controller.command.LoginMember;
import net.shangtech.eshop.shop.controller.command.ShoppingCartCommand;

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
//		ShoppingCartCommand shoppingCart = WebUtils.getSessionAttribute(request, name);
		return null;
	}
	
	private LoginMember loadLoginMember(){
		return (LoginMember) WebUtils.getSessionAttribute(request, SessionScope.LOGIN_MEMBER_KEY);
	}
	
}
