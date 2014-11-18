package net.shangtech.shop.basic.dao.impl;

import java.util.List;

import net.shangtech.framework.dao.hibernate.BaseDao;
import net.shangtech.framework.dao.support.BaseEntity;
import net.shangtech.framework.dao.support.MapHolder;
import net.shangtech.shop.basic.dao.IDivisionPropertyDao;
import net.shangtech.shop.basic.entity.DivisionProperty;

import org.springframework.stereotype.Repository;

@Repository
public class DivisionPropertyDao extends BaseDao<DivisionProperty> implements IDivisionPropertyDao {

	@Override
    public List<DivisionProperty> findByDivisionId(Long divisionId) {
	    return findByProperties(MapHolder.instance("divisionId", divisionId), BaseEntity.ORDER_BY_SORT);
    }

	@Override
    public void deleteByDivisionId(Long divisionId) {
	    exec("delete o from " + DivisionProperty.class.getSimpleName() + " o where o.divisionId=?", divisionId);
    }

}
