package net.shangtech.eshop.shop.controller.command;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

public class MemberLoginCommand implements Serializable {

    private static final long serialVersionUID = 4927315529459597866L;

    /** 邮箱或手机号码 */
    @NotEmpty
    private String username;
    
    @NotEmpty
    private String password;
    
    @NotEmpty
    private String captcha;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
    
}
