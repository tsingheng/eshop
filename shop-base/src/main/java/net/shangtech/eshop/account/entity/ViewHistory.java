package net.shangtech.eshop.account.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Index;

import net.shangtech.framework.orm.dao.support.BaseEntity;

@Entity
@Table(name = "t_view_history")
public class ViewHistory extends BaseEntity<Long> {

	private static final long serialVersionUID = -125475258419388622L;
	
	@Column(name = "ip")
	private String ip;
	
	@Column(name = "member_id")
	@Index(name = "idx_view_history_member_id")
	private Long memberId;
	
	@Column(name = "sku_id")
	@Index(name = "idx_view_history_sku_id")
	private Long skuId;
	
	@Column(name = "view_time")
	private Date viewTime;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public Long getSkuId() {
		return skuId;
	}

	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}

	public Date getViewTime() {
		return viewTime;
	}

	public void setViewTime(Date viewTime) {
		this.viewTime = viewTime;
	}
	
}
