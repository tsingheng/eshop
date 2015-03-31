package net.shangtech.eshop.sales.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Index;

import net.shangtech.framework.dao.support.BaseEntity;

@Entity
@Table(name = "t_order")
public class Order extends BaseEntity<Long> {

	private static final long serialVersionUID = -3139823541653762206L;
	
	@Column(name = "code")
	@Index(name = "idx_order_code")
	private String code;
	
	@Column(name = "create_time")
	@Index(name = "idx_order_create_time")
	private Date createTime;
	
	@Column(name = "member_id")
	@Index(name = "idx_order_member_id")
	private Long memberId;
	
	@Column(name = "payment_type")
	private String paymentType;
	
	@Column(name = "payment_complete_time")
	private Date paymentCompleteTime;
	
	@Column(name = "original_amount")
	private Double originalAmount;
	
	@Column(name = "actual_amount")
	private Double actualAmount;
	
	@Column(name = "original_freight")
	private Double originalFreight;
	
	@Column(name = "actual_freight")
	private Double actualFreight;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "province")
	private String province;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "district")
	private String district;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "mobile")
	private String mobile;
	
	@Column(name = "telephone")
	private String telephone;
	
	@Column(name = "contact")
	private String contact;
	
	@Column(name = "postcode")
	private String postcode;
}
