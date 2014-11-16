package net.shangtech.shop.basic.service.impl;

import javax.transaction.Transactional;

import net.shangtech.framework.service.BaseService;
import net.shangtech.shop.basic.dao.IDivisionDao;
import net.shangtech.shop.basic.entity.Division;
import net.shangtech.shop.basic.service.IDivisionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DivisionService extends BaseService<Division> implements IDivisionService {
	@Autowired private IDivisionDao dao;
}
