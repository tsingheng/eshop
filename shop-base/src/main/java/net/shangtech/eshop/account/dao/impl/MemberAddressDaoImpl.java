package net.shangtech.eshop.account.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.shangtech.eshop.account.dao.MemberAddressDao;
import net.shangtech.eshop.account.entity.MemberAddress;
import net.shangtech.framework.dao.hibernate.BaseDao;

@Repository
public class MemberAddressDaoImpl extends BaseDao<MemberAddress> implements MemberAddressDao {

	@Override
    public List<MemberAddress> findByMemberId(Long memberId) {
	    return findByProperty("member_id", memberId);
    }

}
