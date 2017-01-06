package org.dao.impl;

import java.io.Serializable;

/**
 * ��ҳ��
 * @author yejianyi
 *
 */
public class PageInfo implements Serializable {

	private static final long serialVersionUID = 1878154374135400744L;

	public static int ROWS_PER_PAGE = 15; //Ĭ��ÿҳ��������¼
 
    private int firstResult = 0; //��ҳ�ӵڼ�����¼��ʼ

    private int maxResults = ROWS_PER_PAGE; //һҳ����������¼

    private int pageNo = 0; //��ǰҳ

    private transient int itemCount = 0; //�ܼ�¼��

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
