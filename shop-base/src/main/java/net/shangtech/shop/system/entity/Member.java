package net.shangtech.shop.system.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import net.shangtech.framework.dao.support.BaseEntity;

@Entity
@Table(name = "t_sys_member")
public class Member extends BaseEntity<Long> {

	private static final long serialVersionUID = -1538604924622016767L;

}
