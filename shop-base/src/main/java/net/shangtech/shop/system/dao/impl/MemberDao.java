package net.shangtech.shop.system.dao.impl;

import net.shangtech.framework.dao.hibernate.BaseDao;
import net.shangtech.shop.system.dao.IMemberDao;
import net.shangtech.shop.system.entity.Member;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao extends BaseDao<Member> implements IMemberDao {

}
