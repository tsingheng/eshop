package net.shangtech.eshop.shop.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.shangtech.eshop.product.entity.Brand;
import net.shangtech.eshop.product.entity.Inventory;
import net.shangtech.eshop.product.entity.Sku;
import net.shangtech.eshop.product.service.BrandService;
import net.shangtech.eshop.product.service.InventoryService;
import net.shangtech.eshop.product.service.SkuService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
	
	@Autowired private SkuService skuService;
	
	@Autowired private BrandService brandService;
	
	@Autowired private InventoryService inventoryService;
	
	@RequestMapping("/detail/{code}")
	public String detail(@PathVariable String code, Model model){
		
		Sku sku = skuService.findByCode(code);
		if(sku == null){
			return "shop.product.error";
		}
		model.addAttribute("sku", sku);
		
		Brand brand = brandService.find(sku.getBrandId());
		model.addAttribute("brand", brand);
		
		List<Inventory> inventoryList = inventoryService.findBySkuId(sku.getId());
		model.addAttribute("inventoryList", inventoryList);
		
		//colors
		if(StringUtils.isNotBlank(sku.getColors())){
			List<Sku> colorList = new ArrayList<Sku>();
			colorList.add(sku);
			for(String colorCode : sku.getColors().split(",")){
				colorList.add(skuService.findByVid(colorCode));
			}
			Collections.sort(colorList);
			model.addAttribute("colorList", colorList);
		}
		
		return "shop.product.detail";
	}
	
}
