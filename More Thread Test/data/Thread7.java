package com.pxy.marix.thread;

import java.util.concurrent.Callable;

public class Thread7 extends ThreadFather implements Callable<String> {

	Thread7(int[][] a, int[][] b) {
		super(a, b);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String call() throws Exception {
		MatrixMul(a.length/4,a.length/2,b[0].length/2,b[0].length*3/4);
		return null;
	}

}
