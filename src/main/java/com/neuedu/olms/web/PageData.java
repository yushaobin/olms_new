package com.neuedu.olms.web;

import java.util.List;

public class PageData<T> {
	private int curPage;
	private int totalPage;
	private int totalRecourd;
	private int pageSize;
	private List<T> data;
	
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	
	public PageData(int pageSize,int curPage) {
		this.pageSize = pageSize;
		this.curPage = curPage;
	}
	
	/**
	 * æ±‚æ?»é¡µæ•?
	 * @return
	 */
	public int getTotalPage() {
		totalPage = totalRecourd % pageSize == 0 ? totalRecourd / pageSize 
				                            :  (totalRecourd / pageSize) + 1;
		return totalPage;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalRecourd() {
		return totalRecourd;
	}
	public void setTotalRecourd(int totalRecourd) {
		this.totalRecourd = totalRecourd;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "PageData [curPage=" + curPage + ", totalPage=" + totalPage + ", totalRecourd=" + totalRecourd
				+ ", pageSize=" + pageSize + ", data=" + data + "]";
	}
	
}
