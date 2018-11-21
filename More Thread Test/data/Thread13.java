package com.pxy.marix.thread;

import java.util.concurrent.Callable;

public class Thread13 extends ThreadFather implements Callable<String> {

	Thread13(int[][] a, int[][] b) {
		super(a, b);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String call() throws Exception {
		MatrixMul(a.length*3/4,a.length,0,b[0].length/4);
		return null;
	}

}
