package net.shangtech.eshop.product.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Index;

import net.shangtech.framework.dao.support.BaseEntity;

/**
 * 商品分类
 * @author tsingheng
 *
 */
@Entity
@Table(name = "t_category")
public class Category extends BaseEntity<Long> {

    private static final long serialVersionUID = 1002452745760520064L;
    
    public static final Long 	ROOT_CATE_ID 	= 	0L;
    public static final String 	PATH_SEPARATOR 	= 	"-";

    /** 上级分类ID */
    @Column(name = "parent_id")
    @Index(name = "idx_category_parent_id")
    private Long parentId = ROOT_CATE_ID;
    
    /** 分类名称 */
    @Column(name = "cate_name")
    private String name;
    
    /** 分类编码,英文名称 */
    @Column(name = "cate_code")
	@Index(name = "idx_category_code")
    private String code;
    
    /** 权重值,用来排序 */
    @Column(name = "priority")
    private Integer priority;
    
    /** 是否是叶节点,添加节点时默认是叶节点,给其添加子节点时将leaf改为false,删除子节点时判断如果子节点已经全部删除,再改为true */
    @Column(name = "leaf")
    private Boolean leaf = true;
    
    @Column(name = "create_time")
    private Date createTime;
    
    private Date version;
    
    @Transient
    private List<Category> children;
    
    private String path;

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

	public Boolean getLeaf() {
		return leaf;
	}

	public void setLeaf(Boolean leaf) {
		this.leaf = leaf;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getVersion() {
		return version;
	}

	public void setVersion(Date version) {
		this.version = version;
	}

	public List<Category> getChildren() {
		return children;
	}

	public void setChildren(List<Category> children) {
		this.children = children;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
    
}
