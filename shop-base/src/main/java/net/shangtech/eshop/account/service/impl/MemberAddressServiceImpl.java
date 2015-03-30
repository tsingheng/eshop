package net.shangtech.eshop.account.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import net.shangtech.eshop.account.dao.MemberAddressDao;
import net.shangtech.eshop.account.entity.MemberAddress;
import net.shangtech.eshop.account.service.MemberAddressService;
import net.shangtech.framework.service.BaseService;

public class MemberAddressServiceImpl extends BaseService<MemberAddress> implements MemberAddressService {

	@Autowired private MemberAddressDao dao;
	
	@Override
    public List<MemberAddress> findbyMemberId(Long memberId) {
	    return dao.findByMemberId(memberId);
    }

}
