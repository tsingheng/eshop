package net.shangtech.eshop.manager.controller.sales.command;

import java.io.Serializable;

import net.shangtech.eshop.sales.entity.Area;
import net.shangtech.eshop.sales.entity.Freight;

public class FreightTemplate implements Serializable {
	
    private static final long serialVersionUID = 5620022875299000905L;
    
	private Area area;
	
	private Freight freight;
	
	public Area getArea() {
		return area;
	}
	
	public void setArea(Area area) {
		this.area = area;
	}
	
	public Freight getFreight() {
		return freight;
	}
	
	public void setFreight(Freight freight) {
		this.freight = freight;
	}
	
}
