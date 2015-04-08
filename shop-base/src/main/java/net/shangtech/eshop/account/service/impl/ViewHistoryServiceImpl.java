package net.shangtech.eshop.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.shangtech.eshop.account.dao.ViewHistoryDao;
import net.shangtech.eshop.account.entity.ViewHistory;
import net.shangtech.eshop.account.service.ViewHistoryService;
import net.shangtech.framework.orm.dao.support.Pagination;
import net.shangtech.framework.orm.service.BaseService;

@Service
@Transactional
public class ViewHistoryServiceImpl extends BaseService<ViewHistory> implements ViewHistoryService {

	@Autowired private ViewHistoryDao dao;
	
	@Override
	public Pagination<ViewHistory> findByMemberId(Long memberId, Pagination<ViewHistory> pagination) {
		return dao.findByMemberId(memberId, pagination);
	}
	
}
