package com.pxy.marix.thread;

import java.util.concurrent.Callable;

public class Thread15 extends ThreadFather implements Callable<String> {

	Thread15(int[][] a, int[][] b) {
		super(a, b);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String call() throws Exception {
		MatrixMul(a.length*3/4,a.length,b[0].length/2,b[0].length*3/4);
		return null;
	}

}
