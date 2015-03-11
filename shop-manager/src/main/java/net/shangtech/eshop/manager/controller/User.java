package net.shangtech.eshop.manager.controller;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class User {
	@NotBlank
	private String username;
	
	@NotNull
	private Integer age;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
