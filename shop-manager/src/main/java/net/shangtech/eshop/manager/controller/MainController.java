package net.shangtech.eshop.manager.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import net.shangtech.eshop.manager.spider.ProductSpider;
import net.shangtech.eshop.manager.vo.EasyuiTreeNode;
import net.shangtech.eshop.product.service.ICategoryService;
import net.shangtech.eshop.product.service.IProductService;
import net.shangtech.framework.controller.AjaxResponse;
import net.shangtech.framework.controller.validation.RequestValid;

import org.hibernate.validator.constraints.NotEmpty;
import org.htmlparser.util.ParserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DirectFieldBindingResult;
import org.springframework.validation.beanvalidation.OptionalValidatorFactoryBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired private ICategoryService categoryService;
	@Autowired private IProductService productService;
	@Autowired private OptionalValidatorFactoryBean optionalValidatorFactoryBean;
	
	@RequestMapping("/product")
	public String product() throws FileNotFoundException, ParserException, IOException, InterruptedException{
		new ProductSpider(categoryService, productService).exec();
		return "manager.index";
	}
	
	@RequestMapping("/index")
	public String index(){
		Pojo pojo = new Pojo();
		BindingResult result = new DirectFieldBindingResult(pojo, "pojo", true);
		optionalValidatorFactoryBean.validate(pojo, result);
		logger.info(JSON.toJSONString(result));
		return "manager.index";
	}
	
	@ResponseBody
	@RequestMapping("/menu")
	public List<EasyuiTreeNode> menu(){
		List<EasyuiTreeNode> list = new ArrayList<>();
		EasyuiTreeNode pro = new EasyuiTreeNode();
		pro.setId(1L);
		pro.setState(EasyuiTreeNode.NODE_STATE_CLOSED);
		pro.setText("商品管理");
		list.add(pro);
		
		List<EasyuiTreeNode> proList = new ArrayList<>();
		EasyuiTreeNode cate = new EasyuiTreeNode();
		cate.setId(2L);
		cate.setText("分类管理");
		proList.add(cate);
		EasyuiTreeNode label = new EasyuiTreeNode();
		label.setId(3L);
		label.setText("标签管理");
		proList.add(label);
		pro.setChildren(proList);
		
		EasyuiTreeNode act = new EasyuiTreeNode();
		act.setId(4L);
		act.setText("活动管理");
		list.add(act);
		
		EasyuiTreeNode sys = new EasyuiTreeNode();
		sys.setId(5L);
		sys.setText("系统管理");
		list.add(sys);
		
		return list;
	}
	
	@RequestValid
	@ResponseBody
	@RequestMapping("/valid")
	public Object valid(@RequestParam("id") String id, @RequestValid Pojo test){
		AjaxResponse ajaxResponse = new AjaxResponse();
		ajaxResponse.setSuccess(true);
		return ajaxResponse;
	}
	
//	@RequestMapping("/valid")
//	public String valid(HttpServletRequest request){
//		ServletContext ctx = request.getSession().getServletContext();
//		Enumeration<String> names = ctx.getAttributeNames();
//		while(names.hasMoreElements()){
//			String name = names.nextElement();
//			if(ctx.getAttribute(name) instanceof WebApplicationContext){
//				System.out.println(name + "\t\t\t" + ctx.getAttribute(name));
//			}
//		}
//		System.out.println(optionalValidatorFactoryBean.getValidator());
//		return "manager.index";
//	}
}
class Pojo{
	@NotNull
	private String name;
	
	@Valid
	@NotEmpty
	private List<User> users;
	
	@Valid
	private User user;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}