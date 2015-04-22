package net.shangtech.eshop.shop.controller.command;

import java.io.Serializable;

import net.shangtech.eshop.sales.entity.Shipping;

public class FreightCommand implements Serializable {

	private static final long serialVersionUID = 3727150312671095317L;

	private Shipping shipping;
	
	private Double freight;

	public Shipping getShipping() {
		return shipping;
	}

	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
	}

	public Double getFreight() {
		return freight;
	}

	public void setFreight(Double freight) {
		this.freight = freight;
	}
	
}
