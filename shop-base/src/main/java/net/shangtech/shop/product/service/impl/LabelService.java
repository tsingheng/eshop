package net.shangtech.shop.product.service.impl;

import javax.transaction.Transactional;

import net.shangtech.framework.service.BaseService;
import net.shangtech.shop.product.entity.Label;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class LabelService extends BaseService<Label> {

}
