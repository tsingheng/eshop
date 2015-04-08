package net.shangtech.eshop.account.dao;

import net.shangtech.eshop.account.entity.ViewHistory;
import net.shangtech.framework.orm.dao.IBaseDao;
import net.shangtech.framework.orm.dao.support.Pagination;

public interface ViewHistoryDao extends IBaseDao<ViewHistory> {
	Pagination<ViewHistory> findByMemberId(Long memberId, Pagination<ViewHistory> pagination);
}
