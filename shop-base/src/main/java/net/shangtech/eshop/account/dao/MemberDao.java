package net.shangtech.eshop.account.dao;

import net.shangtech.eshop.account.entity.Member;
import net.shangtech.framework.dao.IBaseDao;

public interface MemberDao extends IBaseDao<Member> {
	Member findByEmail(String email);
	
	Member findByMobile(String mobile);
	
	Member findByThirdId(String thirdId);
}
