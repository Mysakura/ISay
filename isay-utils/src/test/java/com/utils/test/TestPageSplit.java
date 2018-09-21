package com.utils.test;

import org.junit.Test;

import com.internetsaying.utils.PageSplit;

public class TestPageSplit {

	@Test
	public void test() {
//		System.out.println(0/10);
//		System.out.println(0%10);
		PageSplit ps = new PageSplit(1, 0, 2);
		ps.getShowPage().forEach(e -> {
			System.err.println(e);
		});
	}
}
