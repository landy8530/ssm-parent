package com.landy.ssm.commons;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EasyUIDatagrid<E> implements Serializable {

	private static final long serialVersionUID = -1L;
	private long total;
	private List<E> rows;
	
	public EasyUIDatagrid() {
		super();
		this.total = 0;
		this.rows = new ArrayList<>(0);
	}
	public EasyUIDatagrid(long total, List<E> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<E> getRows() {
		return rows;
	}
	public void setRows(List<E> rows) {
		this.rows = rows;
	}
	
}
