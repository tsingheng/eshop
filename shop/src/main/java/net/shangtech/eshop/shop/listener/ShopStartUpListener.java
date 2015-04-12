package net.shangtech.eshop.shop.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import net.shangtech.eshop.product.entity.Category;
import net.shangtech.eshop.product.service.CategoryService;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class ShopStartUpListener implements ServletContextListener {

	private ApplicationContext ac;
	
	private ServletContext sc;
	
	@Override
    public void contextDestroyed(ServletContextEvent event) {
	    
    }

	@Override
    public void contextInitialized(ServletContextEvent event) {
	    sc = event.getServletContext();
	    ac = WebApplicationContextUtils.getWebApplicationContext(sc);
	    
	    sc.setAttribute("ctx", sc.getContextPath());
	    
	    initTopCategoryList();
    }
	
	private void initTopCategoryList(){
		CategoryService categoryService = ac.getBean(CategoryService.class);
		List<Category> topCategoryList = categoryService.findByParentId(Category.ROOT_CATE_ID);
		for(Category category : topCategoryList){
			category.setChildren(categoryService.findByParentId(category.getId()));
		}
		sc.setAttribute("topCategoryList", topCategoryList);
	}

}
