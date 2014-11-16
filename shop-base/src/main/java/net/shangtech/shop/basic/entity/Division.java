package net.shangtech.shop.basic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import net.shangtech.framework.dao.support.BaseEntity;

/**
 * 商品大类,用于商品相关属性基础数据设置
 * @author tsingheng
 *
 */
@Entity
@Table(name = "t_pro_division")
public class Division extends BaseEntity<Long> {

    private static final long serialVersionUID = 680752908651058912L;
    
    @Column(name = "division_name")
    private String divisionName;
    
    @Column(name = "parent_id")
    private Long parentId;

	public String getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
    
}
