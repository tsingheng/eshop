package net.shangtech.eshop.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import net.shangtech.framework.dao.support.BaseEntity;

/**
 * 商品分类
 * @author tsingheng
 *
 */
@Entity
@Table(name = "t_pro_category")
public class Category extends BaseEntity<Long> {

    private static final long serialVersionUID = 1002452745760520064L;

    /** 上级分类ID */
    private Long parentId;
    
    /** 分类名称 */
    private String name;
    
    /** 分类编码,英文名称 */
    private String code;
    
    /** 权重值,用来排序 */
    private Integer priority;
    
    /** 是否是叶节点,添加节点时默认是叶节点,给其添加子节点时将leaf改为false,删除子节点时判断如果子节点已经全部删除,再改为true */
    private Boolean leaf = true;

    @Column(name = "parent_id")
	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	@Column(name = "cate_name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "cate_code")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "priority")
	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	@Column(name = "leaf")
	public Boolean getLeaf() {
		return leaf;
	}

	public void setLeaf(Boolean leaf) {
		this.leaf = leaf;
	}
    
}