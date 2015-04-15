package net.shangtech.eshop.sales.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Index;

import net.shangtech.framework.orm.dao.support.BaseEntity;

/**
 * 物流方式
 * @author tsingheng
 *
 */
@Entity
@Table(name = "t_shipping")
public class Shipping extends BaseEntity<Long> {

    private static final long serialVersionUID = 8040629471286934880L;

    /** 物流名称 */
    @Column(name = "shipping_name")
    private String name;
    
    /** logo图 */
    @Column(name = "logo")
    private String logo;
    
    /** 编号 */
    @Column(name = "code")
    @Index(name = "idx_shipping_code")
    private String code;
    
    /** 顺序 */
    @Column(name = "priority")
    private String priority;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}
    
}
