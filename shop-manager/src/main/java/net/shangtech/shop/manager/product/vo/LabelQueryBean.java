package net.shangtech.shop.manager.product.vo;

import net.shangtech.framework.dao.support.QueryBean;
import net.shangtech.shop.product.entity.Label;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;

import static org.hibernate.criterion.Restrictions.*;

public class LabelQueryBean extends QueryBean {
	
	private String labelName;
	
	private String labelCode;

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

	@Override
	public DetachedCriteria criteria() {
		DetachedCriteria dc = DetachedCriteria.forClass(Label.class);
		if(StringUtils.isNotBlank(labelName)){
			dc.add(like("labelName", labelName));
		}
		if(StringUtils.isNotBlank(labelCode)){
			dc.add(eq("labelCode", labelCode));
		}
		return dc;
	}
	
}
