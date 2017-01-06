package org.dao.impl;

import java.io.Serializable;

/**
 * 分页类
 * @author yejianyi
 *
 */
public class PageInfo implements Serializable {

	private static final long serialVersionUID = 1878154374135400744L;

	public static int ROWS_PER_PAGE = 15; //默认每页多少条记录
 
    private int firstResult = 0; //分页从第几条记录开始

    private int maxResults = ROWS_PER_PAGE; //一页最多多少条记录

    private int pageNo = 0; //当前页

    private transient int itemCount = 0; //总记录数

	public int getFirstResult() {
		return firstResult;
	}

	public void setFirstResult(int firstResult) {
		this.firstResult = firstResult;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	public int getMaxResults() {
		return maxResults;
	}

	public void setMaxResults(int maxResults) {
		this.maxResults = maxResults;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}


 
}
