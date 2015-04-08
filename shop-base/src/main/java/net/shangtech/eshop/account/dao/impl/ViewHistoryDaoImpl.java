package net.shangtech.eshop.account.dao.impl;

import org.springframework.stereotype.Repository;

import net.shangtech.eshop.account.dao.ViewHistoryDao;
import net.shangtech.eshop.account.entity.ViewHistory;
import net.shangtech.framework.orm.dao.hibernate.BaseDao;
import net.shangtech.framework.orm.dao.support.Pagination;

@Repository
public class ViewHistoryDaoImpl extends BaseDao<ViewHistory> implements ViewHistoryDao {

	@Override
	public Pagination<ViewHistory> findByMemberId(Long memberId, Pagination<ViewHistory> pagination) {
		return findPageByProperties("memberId", memberId, pagination);
	}

}
