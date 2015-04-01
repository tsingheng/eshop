package net.shangtech.eshop.account.service.impl;

import java.util.Date;
import java.util.List;

import net.shangtech.eshop.account.dao.MemberAddressDao;
import net.shangtech.eshop.account.entity.Member;
import net.shangtech.eshop.account.entity.MemberAddress;
import net.shangtech.eshop.account.service.MemberAddressService;
import net.shangtech.framework.service.BaseService;

import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberAddressServiceImpl extends BaseService<MemberAddress> implements MemberAddressService {

	@Autowired private MemberAddressDao dao;
	
	@Override
    public List<MemberAddress> findbyMemberId(Long memberId) {
	    return dao.findByMemberId(memberId);
    }
	
	@Override
	public void save(MemberAddress address){
		if(address.getMemberId() == Member.GUEST_MEMBER_ID){
			address.setIsDefault(false);
		}else{
			MemberAddress defaultAddress = dao.findDefaultMemberAddress(address.getMemberId());
			if(BooleanUtils.isTrue(address.getIsDefault()) && defaultAddress != null){
				defaultAddress.setIsDefault(false);
				dao.update(defaultAddress);
			}else if(!BooleanUtils.isTrue(address.getIsDefault()) && defaultAddress == null){
				address.setIsDefault(true);
			}
		}
		address.setCreateTime(new Date());
		dao.save(address);
	}
	
	@Override
	public void update(MemberAddress address){
		if(address.getMemberId() == Member.GUEST_MEMBER_ID){
			address.setIsDefault(false);
		}else{
			MemberAddress defaultAddress = dao.findDefaultMemberAddress(address.getMemberId());
			if(BooleanUtils.isTrue(address.getIsDefault()) && defaultAddress != null && defaultAddress.getId() != address.getId()){
				defaultAddress.setIsDefault(false);
				dao.update(defaultAddress);
			}
			if(defaultAddress == null && !BooleanUtils.isTrue(address.getIsDefault())){
				address.setIsDefault(true);
			}
		}
		MemberAddress old = dao.find(address.getId());
		old.setCity(address.getCity());
		old.setContact(address.getContact());
		old.setDistrict(address.getDistrict());
		old.setEmail(address.getEmail());
		old.setIsDefault(address.getIsDefault());
		old.setMobile(address.getMobile());
		old.setPostcode(address.getPostcode());
		old.setProvince(address.getProvince());
		old.setStreet(address.getStreet());
		dao.update(old);
	}

}
