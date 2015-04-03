package net.shangtech.eshop.shop.controller.command;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class CreateOrderCommand implements Serializable {

	private static final long serialVersionUID = -8088421428266040216L;
	
	@NotNull
	private Long memberAddressId;
	
	private String message;

	public Long getMemberAddressId() {
		return memberAddressId;
	}

	public void setMemberAddressId(Long memberAddressId) {
		this.memberAddressId = memberAddressId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
