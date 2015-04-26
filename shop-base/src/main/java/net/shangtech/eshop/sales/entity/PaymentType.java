package net.shangtech.eshop.sales.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import net.shangtech.framework.orm.dao.support.BaseEntity;

@Entity
@Table(name = "t_payment_type")
public class PaymentType extends BaseEntity<Long> {

    private static final long serialVersionUID = -194066727355824856L;

    @Column(name = "payment_type_name")
    private String name;
    
    @Column(name = "logo")
    private String logo;
    
    @Column(name = "code")
    private String code;

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
    
}
