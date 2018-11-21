package com.pxy.marix.thread;

import java.util.concurrent.Callable;

public class Thread5 extends ThreadFather implements Callable<String> {

	Thread5(int[][] a, int[][] b) {
		super(a, b);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String call() throws Exception {
		MatrixMul(a.length/4,a.length/2,0,b[0].length/4);
		return null;
	}

}
