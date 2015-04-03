package net.shangtech.eshop.shop.controller.utils;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.shangtech.eshop.shop.constants.ShopConstants;
import net.shangtech.eshop.shop.constants.ScopConstants.CookieScope;
import net.shangtech.eshop.shop.controller.command.ShoppingCartCommand;
import net.shangtech.eshop.shop.controller.command.ShoppingCartItemCommand;
import net.shangtech.eshop.shop.controller.command.ShoppingCartItemCookie;

import org.springframework.web.util.WebUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

public class CookieUtils {
	public static List<ShoppingCartItemCookie> getShoppingCartItems(HttpServletRequest request){
		Cookie cookie = WebUtils.getCookie(request, CookieScope.SHOPPING_CART_ITEMS);
		if(cookie != null){
			return JSONArray.parseArray(cookie.getValue(), ShoppingCartItemCookie.class);
		}
		return null;
	}
	
	public static void updateShoppingCartInCookie(HttpServletRequest request, HttpServletResponse response, ShoppingCartCommand shoppingCart){
		List<ShoppingCartItemCookie> list = new ArrayList<ShoppingCartItemCookie>(shoppingCart.getShoppingCartItemList().size());
		for(ShoppingCartItemCommand item : shoppingCart.getShoppingCartItemList()){
			ShoppingCartItemCookie cookieItem = new ShoppingCartItemCookie();
			cookieItem.setCode(item.getCode());
			cookieItem.setQuantity(item.getQuantity());
			list.add(cookieItem);
		}
		Cookie cookie = newCookie(request, CookieScope.SHOPPING_CART_ITEMS, list);
		response.addCookie(cookie);
	}
	
	private static Cookie newCookie(HttpServletRequest request, String name, Object value){
		Cookie cookie = new Cookie(name, JSON.toJSONString(value));
		cookie.setPath(request.getContextPath() + "/");
		cookie.setMaxAge(ShopConstants.COOKIE_MAX_AGE);
		return cookie;
	}
}
