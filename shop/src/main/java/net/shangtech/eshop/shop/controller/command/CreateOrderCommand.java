package net.shangtech.eshop.shop.controller.command;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

public class CreateOrderCommand implements Serializable {

	private static final long serialVersionUID = -8088421428266040216L;
	
	private String message;
	
	@NotEmpty
	private String paymentType;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	
}
