package net.shangtech.eshop.shop.controller.command;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import net.shangtech.framework.web.controller.validation.constraints.Mobile;

import org.hibernate.validator.constraints.NotBlank;

public class MemberAddressCommand implements Serializable {

    private static final long serialVersionUID = 3125931256520353319L;
	
    private Long id;
    
    private String contact;
    
    @NotBlank
    private String firstName;
    
    @NotBlank
    private String lastName;
    
    @NotNull
    private Long countryId;
    
    private String state;
    
    @NotBlank
    private String company;
    
    @NotBlank
    private String address;
    
    private String country;
    
    private String province;
    
    @NotBlank
    private String city;
    
    private String district;
    
    private String street;
    
    @NotBlank
    @Mobile
    private String mobile;
    
    @NotBlank
    private String postcode;
    
    private Boolean isDefault = false;

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
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

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
    
}
