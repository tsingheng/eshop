package net.shangtech.shop.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import net.shangtech.framework.dao.support.BaseEntity;

@Entity
@Table(name = "t_label")
public class Label extends BaseEntity<Long> {

	private static final long serialVersionUID = 6012118993479582391L;

	@Column(name = "label_name")
	private String labelName;
	
	@Column(name = "label_code")
	private String labelCode;
	
	@Column(name = "priority")
	private Integer priority;

	public String getLabelName() {
		return labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}

	public String getLabelCode() {
		return labelCode;
	}

	public void setLabelCode(String labelCode) {
		this.labelCode = labelCode;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	
}
