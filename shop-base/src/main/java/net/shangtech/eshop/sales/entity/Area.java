package net.shangtech.eshop.sales.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import net.shangtech.framework.orm.dao.support.BaseEntity;

/**
 * 国家区域
 * @author tsingheng
 *
 */
@Entity
@Table(name = "t_area")
public class Area extends BaseEntity<Long> {

	private static final long serialVersionUID = -8408809579169045960L;

	@Column(name = "parent_id")
	private Long parentId;
	
	@Column(name = "area_name")
	private String name;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "priority")
	private Integer priority;

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	
}
