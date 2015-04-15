package net.shangtech.eshop.sales.service.impl;

import net.shangtech.eshop.sales.dao.AreaDao;
import net.shangtech.eshop.sales.entity.Area;
import net.shangtech.eshop.sales.service.AreaService;
import net.shangtech.framework.orm.service.BaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AreaServiceImpl extends BaseService<Area> implements AreaService {
	
	@Autowired private AreaDao dao;
	
}
