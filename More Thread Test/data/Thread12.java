package com.pxy.marix.thread;

import java.util.concurrent.Callable;

public class Thread12 extends ThreadFather implements Callable<String> {

	Thread12(int[][] a, int[][] b) {
		super(a, b);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String call() throws Exception {
		MatrixMul(a.length/2,a.length*3/4,b.length*3/4,b[0].length);
		return null;
	}

}
