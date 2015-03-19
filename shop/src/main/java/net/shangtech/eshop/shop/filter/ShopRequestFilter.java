package net.shangtech.eshop.shop.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.util.UrlPathHelper;

/**
 * 对列表页进行转发
 */
public class ShopRequestFilter implements Filter {
	
	private static final Logger logger = LoggerFactory.getLogger(ShopRequestFilter.class);

	private static final UrlPathHelper urlPathHelper = new UrlPathHelper();
	
	private static final String CATEGORY_LIST_REQUEST_ENDING = "/list";
	
	private static final String LABEL_LIST_REQUEST_START = "/group/";
	
	private static final String CATEGORY_LIST_REQUEST_START = "/cate";
	
	public void destroy() {
		
	}

	/**
	 * 
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String uri = urlPathHelper.getRequestUri((HttpServletRequest) request);
		String ctx = request.getServletContext().getContextPath();
		uri = uri.substring(ctx.length());
		logger.debug("request for {}", uri);
		if(uri.endsWith(CATEGORY_LIST_REQUEST_ENDING) && !uri.startsWith(LABEL_LIST_REQUEST_START) && !uri.startsWith(CATEGORY_LIST_REQUEST_START) && !uri.equals(CATEGORY_LIST_REQUEST_ENDING)){
			String categories = uri.substring(0, uri.lastIndexOf("/")).replaceAll("/", "-");
			String forwarUri = CATEGORY_LIST_REQUEST_START + categories + CATEGORY_LIST_REQUEST_ENDING;
			logger.debug("forward {} to {}", uri, forwarUri);
			request.getRequestDispatcher(forwarUri).forward(request, response);
			return;
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig config) throws ServletException {
		
	}

}
