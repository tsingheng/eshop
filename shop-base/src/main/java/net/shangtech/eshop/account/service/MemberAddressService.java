package net.shangtech.eshop.account.service;

import java.util.List;

import net.shangtech.eshop.account.entity.MemberAddress;
import net.shangtech.framework.service.IBaseService;

public interface MemberAddressService extends IBaseService<MemberAddress> {
	List<MemberAddress> findbyMemberId(Long memberId);
}
