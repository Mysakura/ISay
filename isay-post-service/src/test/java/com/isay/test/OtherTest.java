package com.isay.test;

import java.util.Date;
import java.util.Set;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

import com.internetsaying.utils.IDUtils;

public class OtherTest {

	@Test
	public void uniqueID() {
		System.out.println(Math.pow(34, 7));
	}
	
	public static void main(String[] args) {
		int concurrentNum = 40000;	//并发数
		CyclicBarrier c = new CyclicBarrier(concurrentNum);		// 让线程同时开始
		CountDownLatch l = new CountDownLatch(concurrentNum);	// 所有线程结束在执行统计
		
		Set<String> set = ConcurrentHashMap.newKeySet();		// Set集合，存储生成的ID
		ExecutorService es = Executors.newCachedThreadPool();
		for (int i = 0; i < concurrentNum; i++) {
			es.submit(new Demo(set,c,l));
		}
		es.shutdown();
		
		try {
			l.await();	// 前面的任务执行完才到下一步
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(set.size());
	}
}

class Demo implements Runnable{

	private Set<String> set;
	private CyclicBarrier c;
	private CountDownLatch l;
	

	public Demo(Set<String> set, CyclicBarrier c, CountDownLatch l) {
		super();
		this.set = set;
		this.c = c;
		this.l = l;
	}


	@Override
	public void run() {
		try {
			c.await();	// 等待，直到有足够的线程
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String id20 = IDUtils.createID20(new Date());
		set.add(id20);
		l.countDown();	// 每当有线程结束就减1
	}
	
}