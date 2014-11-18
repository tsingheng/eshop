package net.shangtech.shop.basic.dao.impl;

import net.shangtech.framework.dao.hibernate.BaseDao;
import net.shangtech.shop.basic.dao.IDivisionPropertyValueDao;
import net.shangtech.shop.basic.entity.DivisionPropertyValue;

import org.springframework.stereotype.Repository;

@Repository
public class DivisionPropertyValueDao extends BaseDao<DivisionPropertyValue> implements IDivisionPropertyValueDao {

	@Override
    public void deleteByDivisionPropertyId(Long divisionPropertyId) {
	    exec("delete o from " + DivisionPropertyValue.class.getSimpleName() + " o where divisionPropertyId=?", divisionPropertyId);
    }

}
