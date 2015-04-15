package net.shangtech.eshop.manager.controller.sales;

import java.util.List;

import net.shangtech.eshop.manager.controller.sales.command.FreightTemplate;
import net.shangtech.eshop.sales.entity.Area;
import net.shangtech.eshop.sales.entity.Freight;
import net.shangtech.eshop.sales.entity.Shipping;
import net.shangtech.eshop.sales.service.AreaService;
import net.shangtech.eshop.sales.service.FreightService;
import net.shangtech.eshop.sales.service.ShippingService;
import net.shangtech.framework.web.controller.AjaxResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@Autowired private FreightService freightService;
	
	/**
	 * 地区和物流方式基础数据维护
	 * @param model
	 * @return
	 */
	@RequestMapping("/area-and-shipping")
	public String areaAndShipping(Model model){
		List<Area> areaList = areaService.findAll();
		List<Shipping> shippingList = shippingService.findAll();
		model.addAttribute("areaList", areaList);
		model.addAttribute("shippingList", shippingList);
		return "manager.area.and.shipping";
	}
	
	/**
	 * 运费模板设置
	 * @param model
	 * @return
	 */
	@RequestMapping("/shipping")
	public String shipping(Model model){
		List<Area> areaList = areaService.findAll();
		model.addAttribute("areaList", areaList);
		return "manager.area.shipping";
	}
	
	@ResponseBody
	@RequestMapping("/save-freight")
	public AjaxResponse saveFreight(Freight freight){
		AjaxResponse ajaxResponse = AjaxResponse.instance();
		freightService.save(freight);
		ajaxResponse.setSuccess(true);
		return ajaxResponse;
	}
	
	@ResponseBody
	@RequestMapping("/freight-template")
	public List<FreightTemplate> freightTemplate(Long shippingId){
		//List<Freight> freightList = freightService.findByShippingId(shippingId);
		//List<Area> areaList = areaService.findAll();
		
		
		return null;
	}
	
}
