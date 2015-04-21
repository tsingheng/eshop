package net.shangtech.eshop.sales.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Index;

import net.shangtech.eshop.account.entity.MemberAddress;
import net.shangtech.framework.orm.dao.support.BaseEntity;

/**
 * 订单收货地址
 * @author tsingheng
 *
 */
@Entity
@Table(name = "t_order_address")
public class OrderAddress extends BaseEntity<Long> {

    private static final long serialVersionUID = 5830021874006299836L;

    @Column(name = "order_id")
    @Index(name = "idx_bill_address_order_id")
    private Long orderId;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "last_name")
    private String lastName;
    
    @Column(name = "company")
    private String company;
    
    @Column(name = "mobile")
    private String mobile;
    
    @Column(name = "country")
    private String country;
    
    @Column(name = "state")
    private String state;
    
    @Column(name = "city")
    private String city;
    
    @Column(name = "address")
    private String address;
    
    @Column(name = "postcode")
    private String postcode;
    
    @Column(name = "member_id")
    @Index(name = "idx_order_address_member_id")
    private Long memberId;
    
    @Column(name = "create_time")
    private Date createTime;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
    
	public static OrderAddress build(MemberAddress memberAddress){
		OrderAddress orderAddress = new OrderAddress();
		
		return orderAddress;
	}
}
