package net.shangtech.eshop.sales.service.bo;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class OrderBo {
	
	@NotNull
	private Long memberId;
	
	@NotNull
	private Long memberAddressId;
	
	@NotNull
	private Double originalAmount;
	
	@NotNull
	private Double actualAmount;
	
	@NotNull
	private Integer quantity;
	
	@NotNull
	private Double originalFreight;
	
	@NotNull
	private Double actualFreight;
	
	private String message;
	
	@Valid
	@NotEmpty
	private List<OrderItemBo> items;

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public Long getMemberAddressId() {
		return memberAddressId;
	}

	public void setMemberAddressId(Long memberAddressId) {
		this.memberAddressId = memberAddressId;
	}

	public Double getOriginalAmount() {
		return originalAmount;
	}

	public void setOriginalAmount(Double originalAmount) {
		this.originalAmount = originalAmount;
	}

	public Double getActualAmount() {
		return actualAmount;
	}

	public void setActualAmount(Double actualAmount) {
		this.actualAmount = actualAmount;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getOriginalFreight() {
		return originalFreight;
	}

	public void setOriginalFreight(Double originalFreight) {
		this.originalFreight = originalFreight;
	}

	public Double getActualFreight() {
		return actualFreight;
	}

	public void setActualFreight(Double actualFreight) {
		this.actualFreight = actualFreight;
	}

	public List<OrderItemBo> getItems() {
		return items;
	}

	public void setItems(List<OrderItemBo> items) {
		this.items = items;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
