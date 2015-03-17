package net.shangtech.eshop.shop.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ShopStartUpListener implements ServletContextListener {

	@Override
    public void contextDestroyed(ServletContextEvent event) {
	    
    }

	@Override
    public void contextInitialized(ServletContextEvent event) {
	    ServletContext ctx = event.getServletContext();
	    
	    ctx.setAttribute("ctx", ctx.getContextPath());
    }

}
