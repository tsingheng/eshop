package net.shangtech.eshop.shop.constants;

public class ScopConstants {
	public static final class SessionScope{
		/** 验证码 */
		public static final String CAPTCHA_KEY = "captcha_key";
		
		/** 已登录用户 */
		public static final String LOGIN_MEMBER_KEY = "login_member_key";
		
		/** 购物车 */
		public static final String SHOPPING_CART_COMMAND_KEY = "shopping_cart_command_key";
	}
	
	public static final class CookieScope{
		public static final String SHOPPING_CART_ITEMS = "shopping_cart_items_key";
		
		public static final String VIEW_HISTORY_KEY = "view_history_key";
	}
}
