package net.shangtech.eshop.account.dao.impl;

import net.shangtech.eshop.account.dao.MemberDao;
import net.shangtech.eshop.account.entity.Member;
import net.shangtech.framework.orm.dao.hibernate.BaseDao;

import org.springframework.stereotype.Repository;

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
