package com.pxy.marix.thread;

import java.util.concurrent.Callable;

public class Thread9 extends ThreadFather implements Callable<String> {

	Thread9(int[][] a, int[][] b) {
		super(a, b);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String call() throws Exception {
		MatrixMul(a.length/2,a.length*3/4,0,b[0].length/4);
		return null;
	}

}
