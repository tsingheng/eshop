package net.shangtech.eshop.product.entity;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;

import org.hibernate.annotations.Index;

import net.shangtech.framework.dao.support.BaseEntity;

@Entity
@Table(name = "t_brand")
public class Brand extends BaseEntity<Long> {

    private static final long serialVersionUID = -6783573054065025333L;

    @Column(name = "brand_name")
    private String name;
    
    @Column(name = "english_name")
    private String englishName;
    
    @Index(name = "idx_brand_code")
    private String code;
    
    @Column(name = "sn")
    @Index(name = "idx_brand_sn")
    private String sn;
    
    private String logo;

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

	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}
    
}
