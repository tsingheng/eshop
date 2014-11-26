package net.shangtech.shop.product.service.impl;

import javax.transaction.Transactional;

import net.shangtech.framework.service.BaseService;
import net.shangtech.shop.product.dao.ILabelDao;
import net.shangtech.shop.product.entity.Label;
import net.shangtech.shop.product.service.ILabelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
@Transactional
public class LabelService extends BaseService<Label> implements ILabelService {
	
	@Autowired private ILabelDao dao;
	
	@Override
	public void update(Label label){
		Assert.notNull(label.getId(), "");
		Label old = dao.find(label.getId());
		old.setLabelCode(label.getLabelCode());
		old.setLabelName(label.getLabelName());
		dao.update(old);
	}
}
