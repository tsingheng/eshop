package net.shangtech.eshop.manager.vo;

import java.io.Serializable;
import java.util.List;

public class EasyuiPage<T> implements Serializable {
	
    private static final long serialVersionUID = -3401549287355852363L;

	private Integer total;
	
	private List<T> rows;

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	
}
