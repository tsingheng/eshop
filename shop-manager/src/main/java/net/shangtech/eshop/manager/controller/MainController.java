package net.shangtech.eshop.manager.controller;

import java.util.ArrayList;
import java.util.List;

import net.shangtech.eshop.manager.vo.EasyuiTreeNode;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
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