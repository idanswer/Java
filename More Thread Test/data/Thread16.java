package com.pxy.marix.thread;

import java.util.concurrent.Callable;

public class Thread16 extends ThreadFather implements Callable<String> {

	Thread16(int[][] a, int[][] b) {
		super(a, b);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String call() throws Exception {
		MatrixMul(a.length*3/4,a.length,b[0].length*3/4,b[0].length);
		return null;
	}

}
