package com.internetsaying.utils;

public class PageUtils {

	private static int PageSize = 10;	//每一页显示数量
	private int curPage;				//当前页
	private int allPage;				//总页数
	private int allRecords;				//总记录数
	private int isLast = 1;
	
	public PageUtils() {}

	/**
	 * 设置当前页和总记录数目
	 * @param curPage
	 * @param allRecords
	 */
	public PageUtils(int curPage, long allRecords) {
		super();
		this.curPage = curPage;
		this.allRecords = (int) allRecords;
	}

	/**
	 * 获取每页显示的记录数
	 * @return
	 */
	public static int getPageSize() {
		return PageSize;
	}
	
	/**
	 * 获取当前页
	 * @return
	 */
	public int getCurPage() {
		if(curPage <= 0){
			curPage = 1;
		}else if(curPage > getAllPage()){
			if(allPage == 0)
				curPage = 1;
			else
				curPage = getAllPage();
		}
		return curPage;
	}

	/**
	 * 获取总页数（无数据的时候，总页数为0）
	 * @return
	 */
	public int getAllPage() {
		allPage = allRecords / getPageSize();
		if(allRecords % getPageSize() != 0){
			allPage++;
		}
		return allPage;
	}
	
	/**
	 * 下一页
	 * @return
	 */
	public int nextPage() {
		int next = curPage+1;
		if(next > allPage) {
			next = allPage;	// 下一页最大为总页数
			isLast = 0;		// 如果为总页数，则没有下一页,设置为0
		}
		return next;
	}
	
	/**
	 * 是否最后一页
	 * @return
	 */
	public int getIsLast() {
		return isLast;
	}
}
