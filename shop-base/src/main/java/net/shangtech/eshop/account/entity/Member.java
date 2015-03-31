package net.shangtech.eshop.account.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Index;

import net.shangtech.framework.dao.support.BaseEntity;

@Entity
@Table(name = "t_member")
public class Member extends BaseEntity<Long> {

    private static final long serialVersionUID = 2575512302919390212L;
    
    public static final Long GUEST_MEMBER_ID = 0L;

    @Column(name = "email")
    @Index(name = "idx_member_email")
    private String email;
    
    @Column(name = "password")
    private String passwrod;
    
    @Column(name = "nick_name")
    private String nickName;
    
    @Column(name = "mobile")
    @Index(name = "idx_member_mobile")
    private String mobile;
    
    /** 第三方联合登陆id */
    @Column(name = "third_id")
    @Index(name = "idx_member_third_id")
    private String thirdId;
    
    @Column(name = "gender")
    private String gender;
    
    @Column(name = "birthday")
    @Index(name = "idx_member_birthday")
    private Date birthday;
    
    @Column(name = "source")
    @Index(name = "idx_member_source")
    private String source;
    
    @Column(name = "create_time")
    @Index(name = "idx_member_create_time")
    private Date createTime;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswrod() {
		return passwrod;
	}

	public void setPasswrod(String passwrod) {
		this.passwrod = passwrod;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getThirdId() {
		return thirdId;
	}

	public void setThirdId(String thirdId) {
		this.thirdId = thirdId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
    
}
