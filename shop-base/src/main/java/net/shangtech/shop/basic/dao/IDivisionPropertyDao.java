package net.shangtech.shop.basic.dao;

import java.util.List;

import net.shangtech.framework.dao.IBaseDao;
import net.shangtech.shop.basic.entity.DivisionProperty;

public interface IDivisionPropertyDao extends IBaseDao<DivisionProperty> {
	List<DivisionProperty> findByDivisionId(Long divisionId);
	
	void deleteByDivisionId(Long divisionId);
}
