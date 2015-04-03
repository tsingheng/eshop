package net.shangtech.eshop.sales.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import net.shangtech.framework.orm.dao.support.BaseEntity;

import org.hibernate.annotations.Index;

@Entity
@Table(name = "t_order")
public class Order extends BaseEntity<Long> {

	private static final long serialVersionUID = -3139823541653762206L;
	
	@Column(name = "code")
	@Index(name = "idx_order_code")
	private String code;
	
	@Column(name = "create_time")
	@Index(name = "idx_order_create_time")
	private Date createTime;
	
	@Column(name = "member_id")
	@Index(name = "idx_order_member_id")
	private Long memberId;
	
	@Column(name = "payment_type")
	private String paymentType;
	
	@Column(name = "payment_complete_time")
	private Date paymentCompleteTime;
	
	@Column(name = "original_amount")
	private Double originalAmount;
	
	@Column(name = "actual_amount")
	private Double actualAmount;
	
	@Column(name = "original_freight")
	private Double originalFreight;
	
	@Column(name = "actual_freight")
	private Double actualFreight;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "province")
	private String province;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "district")
	private String district;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "mobile")
	private String mobile;
	
	@Column(name = "telephone")
	private String telephone;
	
	@Column(name = "contact")
	private String contact;
	
	@Column(name = "postcode")
	private String postcode;
	
	@Column(name = "message")
	private String message;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public Date getPaymentCompleteTime() {
		return paymentCompleteTime;
	}

	public void setPaymentCompleteTime(Date paymentCompleteTime) {
		this.paymentCompleteTime = paymentCompleteTime;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
