package net.shangtech.eshop.shop.controller.command;

import java.io.Serializable;

/**
 * 登录用户
 * @author tsingheng
 *
 */
public class LoginMember implements Serializable {
	
    private static final long serialVersionUID = 4978241730947990245L;

	private Long id;
	
	private String ip;
	
	private String username;
	
	private String nickname;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
}
