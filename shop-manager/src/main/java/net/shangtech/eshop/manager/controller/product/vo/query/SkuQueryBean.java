package net.shangtech.eshop.manager.controller.product.vo.query;

import java.util.List;

import net.shangtech.eshop.product.entity.Sku;
import net.shangtech.framework.dao.support.QueryBean;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.util.CollectionUtils;

public class SkuQueryBean implements QueryBean {
	
	private String code;
	
	private List<Long> categoryIds;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Long> getCategoryIds() {
		return categoryIds;
	}

	public void setCategoryIds(List<Long> categoryIds) {
		this.categoryIds = categoryIds;
	}

	@Override
    public DetachedCriteria criteria() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Sku.class);
		if(StringUtils.isNotBlank(code)){
			criteria.add(Restrictions.eq("code", code));
		}
		if(!CollectionUtils.isEmpty(categoryIds)){
			criteria.add(Restrictions.in("categoryId", categoryIds));
		}
	    return criteria;
    }
	
}
