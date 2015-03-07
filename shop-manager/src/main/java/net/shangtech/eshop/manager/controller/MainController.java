package net.shangtech.eshop.manager.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.shangtech.eshop.manager.spider.ProductSpider;
import net.shangtech.eshop.manager.vo.EasyuiTreeNode;
import net.shangtech.eshop.product.service.ICategoryService;
import net.shangtech.eshop.product.service.IProductService;

import org.htmlparser.util.ParserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@Autowired private ICategoryService categoryService;
	@Autowired private IProductService productService;
	
	@RequestMapping("/product")
	public String product() throws FileNotFoundException, ParserException, IOException, InterruptedException{
		new ProductSpider(categoryService, productService).exec();
		return "manager.index";
	}
	
	@RequestMapping("/index")
	public String index(){
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
}
