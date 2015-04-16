package net.shangtech.eshop.manager.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ShopStartUpListener implements ServletContextListener {

	private ServletContext sc;
	
	@Override
    public void contextDestroyed(ServletContextEvent event) {
	    
    }

	@Override
    public void contextInitialized(ServletContextEvent event) {
	    sc = event.getServletContext();
	    
	    sc.setAttribute("ctx", sc.getContextPath());
    }

}
