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

    private String name;
    
    private String englishName;
    
    private String code;
    
    private String sn;
    
    private String logo;

    @Column(name = "brand_name")
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

	@Column(name = "english_name")
	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	@Index(name = "idx_pro_brand_sn")
	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}
    
}
