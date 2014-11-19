package net.shangtech.shop.product.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import net.shangtech.framework.dao.support.BaseEntity;

@Entity
@Table(name = "t_product")
public class Product extends BaseEntity<Long> {

	private static final long serialVersionUID = 2563823795351446074L;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "create_time")
	private Date createTime;
}
