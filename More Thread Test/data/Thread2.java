package com.pxy.marix.thread;

import java.util.concurrent.Callable;

public class Thread2 extends ThreadFather implements Callable<String> {
	public Thread2(int[][] a,int[][]b) {
		super(a,b);
	}
	@Override
	public String call() throws Exception {
		MatrixMul(0,a.length/4,b[0].length/4,b[0].length/2);
		return "success";
	}
	
}
