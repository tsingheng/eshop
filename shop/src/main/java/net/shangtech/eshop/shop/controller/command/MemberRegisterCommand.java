package net.shangtech.eshop.shop.controller.command;

import java.io.Serializable;

import javax.validation.Valid;

import net.shangtech.framework.enums.Gender;
import net.shangtech.framework.web.controller.validation.Password;
import net.shangtech.framework.web.controller.validation.constraints.Enum;
import net.shangtech.framework.web.controller.validation.constraints.Mobile;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class MemberRegisterCommand implements Serializable {

    private static final long serialVersionUID = 749570551358551183L;

    @Email
    @NotEmpty
    private String email;
    
    @NotEmpty
    @Mobile
    private String mobile;
    
    @NotEmpty
    @Enum(target = Gender.class)
    private String gender;
    
    @Valid
    @net.shangtech.framework.web.controller.validation.constraints.Password
    private Password pass = new Password();
    
    /** 验证码 */
    @NotEmpty
    private String captcha;

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Password getPass() {
		return pass;
	}

	public void setPass(Password pass) {
		this.pass = pass;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
    
}
