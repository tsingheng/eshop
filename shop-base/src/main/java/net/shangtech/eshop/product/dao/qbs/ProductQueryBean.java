package net.shangtech.eshop.product.dao.qbs;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import net.shangtech.eshop.product.entity.Product;
import net.shangtech.framework.dao.support.QueryBean;

public class ProductQueryBean implements QueryBean {
	
	private String code;
	
	private Long categoryId;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	@Override
    public DetachedCriteria criteria() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		if(StringUtils.isNotBlank(code)){
			criteria.add(Restrictions.eq("code", code));
		}
		if(categoryId != null){
			criteria.add(Restrictions.eq("categoryId", categoryId));
		}
	    return criteria;
    }
	
}
