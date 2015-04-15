package net.shangtech.eshop.manager.controller.sales;

import java.util.List;

import net.shangtech.eshop.sales.entity.Area;
import net.shangtech.eshop.sales.entity.Shipping;
import net.shangtech.eshop.sales.service.AreaService;
import net.shangtech.eshop.sales.service.ShippingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 跟运费相关的操作
 * @author tsingheng
 *
 */
@Controller
@RequestMapping("/shipping")
public class ShippingController {
	
	@Autowired private AreaService areaService;
	
	@Autowired private ShippingService shippingService;
	
	@RequestMapping("/area-and-shipping")
	public String areaAndShipping(Model model){
		List<Area> areaList = areaService.findAll();
		List<Shipping> shippingList = shippingService.findAll();
		model.addAttribute("areaList", areaList);
		model.addAttribute("shippingList", shippingList);
		return "manager.area.and.shipping";
	}
	
}
