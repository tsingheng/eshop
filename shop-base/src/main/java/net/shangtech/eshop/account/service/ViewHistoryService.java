package net.shangtech.eshop.account.service;

import net.shangtech.eshop.account.entity.ViewHistory;
import net.shangtech.framework.orm.dao.support.Pagination;
import net.shangtech.framework.orm.service.IBaseService;

public interface ViewHistoryService extends IBaseService<ViewHistory> {
	Pagination<ViewHistory> findByMemberId(Long memberId, Pagination<ViewHistory> pagination);
}
