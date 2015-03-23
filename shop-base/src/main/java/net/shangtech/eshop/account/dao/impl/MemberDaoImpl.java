package net.shangtech.eshop.account.dao.impl;

import org.springframework.stereotype.Repository;

import net.shangtech.eshop.account.dao.MemberDao;
import net.shangtech.eshop.account.entity.Member;
import net.shangtech.framework.dao.hibernate.BaseDao;

@Repository
public class MemberDaoImpl extends BaseDao<Member> implements MemberDao {

	@Override
    public Member findByEmail(String email) {
	    return findOneByProperty("email", email);
    }

	@Override
    public Member findByMobile(String mobile) {
	    return findOneByProperty("mobile", mobile);
    }

	@Override
    public Member findByThirdId(String thirdId) {
	    return findOneByProperty("thirdId", thirdId);
    }
	
}
