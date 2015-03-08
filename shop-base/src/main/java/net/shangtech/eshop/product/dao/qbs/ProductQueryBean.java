package net.shangtech.eshop.product.dao.qbs;

import java.util.Arrays;

import net.shangtech.eshop.product.entity.Category;
import net.shangtech.eshop.product.entity.Product;
import net.shangtech.framework.dao.support.QueryBean;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

public class ProductQueryBean implements QueryBean {
	
	private String code;
	
	private Category category;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
    public DetachedCriteria criteria() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		if(StringUtils.isNotBlank(code)){
			criteria.add(Restrictions.eq("code", code));
		}
		if(category != null && StringUtils.isNotBlank(category.getPath())){
			criteria.add(Restrictions.in("categoryId", Arrays.asList(category.getPath().split(Category.PATH_SEPARATOR))));
		}
	    return criteria;
    }
	
}
