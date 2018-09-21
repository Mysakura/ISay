package com.internetsaying.utils;

import java.util.ArrayList;
import java.util.List;

public class PageSplit {

	private int curPage;
	private int allPage;
	private int n;
	
	public PageSplit(){}
	
	public PageSplit(int curPage, int allPage, int n) {
		super();
		this.curPage = curPage;
		this.allPage = allPage;
		this.n = n;
	}

	/**
	 * 1.先找到当前页左边和右边固定数目的页码prev，next
	 * 2.找到之后，过滤掉非法的页码，加上当前页码，然后组合成新数组temp
	 * 3.找到temp最前面的那个页码与1比较，看是否满足加省略号的条件（等于1，等于2，大于2）
	 * 4.找到temp最后面的那个页码与总页码比价，看是否满足加省略号的条件（等于all，等于all-1，小于all-1）
	 * 5.组合成数组temp2
	 * 6.找到当前页码的上一页和下一页
	 * 7.把上一页+temp2+下一页+总页码=pagelist
	 * 
	 * 
	 * @param curPage	当前页码
	 * @param allPage	总页码
	 * @param n			当前页码左或者右显示几个额外页码
	 * @return
	 */
	public List<PageNumber> getShowPage(){
		List<PageNumber> list = new ArrayList<>();
		// 总页数为0，则只返回一个总页数
		if(allPage == 0) {
			list.add(new PageNumber(0, "6"));
			return list;
		}
		Integer[] prevs = getPrevPages(curPage, allPage, n);
		Integer[] nexts = getNextPages(curPage, allPage, n);
		Integer[] pn = getPN(curPage, allPage);
		List<PageNumber> temp = new ArrayList<>();		//存储的是【p-2,p-1,p,p+1,p+2】
		List<PageNumber> temp2 = new ArrayList<>();		//存储的是1...【p-2,p-1,p,p+1,p+2】...20
		
		list.add(new PageNumber(pn[0], "1"));	//加入上一页
		
		
		for(int i = n; i > 0; i--){
			int data = prevs[i-1];
//			System.out.println("当前页之前" + data);
			if(data != -1){
				temp.add(new PageNumber(data, "2"));
			}
		}
//		System.out.println("当前页：" + curPage);
		temp.add(new PageNumber(curPage, "4"));
		for(int i = 0; i < n; i++){
			int data = nexts[i];
//			System.out.println("当前页之后" + data);
			if(data != -1){
				temp.add(new PageNumber(data, "2"));
			}
		}
		//System.out.println("============================");
		//整理前面页码
		if(temp.get(0).getPageNo() == 1){		//当前页码之前最前面的那个页码恰好为第一页
//			System.out.println("不需要1");
//			for(PageNumber i : temp){
//				temp2.add(i);
//			}
		}else if((temp.get(0).getPageNo()-1) == 1){		//当前页码之前最前面的那个页码-1恰好为第一页
//			System.out.println("需要1,不需要省略号");
			temp2.add(new PageNumber(1, "2"));
//			for(PageNumber i : temp){
//				temp2.add(i);
//			}
		}else{									//当前页码之前最前面的那个页码-1还不是第一页
//			System.out.println("需要1");
			temp2.add(new PageNumber(1, "2"));
			temp2.add(new PageNumber(999999, "3"));
//			for(PageNumber i : temp){
//				temp2.add(i);
//			}
		}
		for(PageNumber i : temp){
			temp2.add(i);
		}
		
		//整理后面页码
		if(temp.get(temp.size()-1).getPageNo() == allPage){
//			System.out.println("不需要ALL");
		}else if((temp.get(temp.size()-1).getPageNo()+1) == allPage){	//当前页码之后最后那个页码+1恰好为总页码
//			System.out.println("需要ALL,不需要省略号");
			temp2.add(new PageNumber(allPage, "2"));
		}else {
//			System.out.println("需要ALL");
			temp2.add(new PageNumber(999999, "3"));
			temp2.add(new PageNumber(allPage, "2"));
		}
		for(PageNumber p : temp2){
//			System.out.println(p);
			list.add(p);
		}
		list.add(new PageNumber(pn[1], "5"));	//加入下一页
		list.add(new PageNumber(allPage, "6"));	//加入总页码
		
		return list;
	}
	
	private Integer[] getPrevPages(int curPage, int allPage, int n){
		Integer[] nums = new Integer[n];
		for(int i = 0; i < n; i++){
			int t = curPage - 1;
//			System.out.println("prev:" + t);
			if(t < 1){
				nums[i] = -1;	//小于最低页码，赋值为-1
			}else{
				nums[i] = t;	//正常赋值
			}
			curPage--;
		}
		
		return nums;
	}
	private Integer[] getNextPages(int curPage, int allPage, int n){
		Integer[] nums = new Integer[n];
		for(int i = 0; i < n; i++){
			int t = curPage + 1;
//			System.out.println("next:" + t);
			if(t > allPage){
				nums[i] = -1;	//超出总页码，就赋值为-1
			}else{
				nums[i] = t;	//没有超出总页码，正常赋值
			}
			curPage++;
		}
		
		return nums;
	}
	
	//获取当前页码的上一页和下一页
	private Integer[] getPN(int curPage, int allPage){
		Integer[] nums = new Integer[2];
		int prev = curPage - 1;
		int next = curPage + 1;
		if(prev < 1){
			prev = 1;
		}
		if(next > allPage){
			next = allPage;
		}
		nums[0] = prev;
		nums[1] = next;
		return nums;
	}
}
