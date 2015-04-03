package net.shangtech.eshop.product.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import net.shangtech.framework.orm.dao.support.BaseEntity;

import org.hibernate.annotations.Index;

@Entity
@Table(name = "t_comment")
public class Comment extends BaseEntity<Long> {

	private static final long serialVersionUID = -8854864596110928985L;

	@Column(name = "sku_id")
	@Index(name = "idx_comment_sku_id")
	private Long skuId;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "ip")
	private String ip;
	
	@Column(name = "create_time")
	private String createTime;
	
	@Column(name = "member_id")
	@Index(name = "idx_comment_member_id")
	private Long memberId;
	
	@Column(name = "score")
	private Integer score;
	
	@Column(name = "reply")
	private String reply;
	
	@Column(name = "reply_time")
	private Date replyTime;
	
	@Column(name = "status")
	private String status;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public Date getReplyTime() {
		return replyTime;
	}

	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getSkuId() {
		return skuId;
	}

	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}
	
}
