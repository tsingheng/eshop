package net.shangtech.shop.product.dao.impl;

import net.shangtech.framework.dao.hibernate.BaseDao;
import net.shangtech.shop.product.dao.ILabelDao;
import net.shangtech.shop.product.entity.Label;
import org.springframework.stereotype.Repository;

@Repository
public class LabelDao extends BaseDao<Label> implements ILabelDao {

}
