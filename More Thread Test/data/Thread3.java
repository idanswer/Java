package com.pxy.marix.thread;

import java.util.concurrent.Callable;

public class Thread3 extends ThreadFather implements Callable<String> {

	Thread3(int[][] a, int[][] b) {
		super(a, b);

	}

	@Override
	public String call() throws Exception {
		MatrixMul(0,a.length/4,b[0].length/2,b[0].length*3/4);
		return null;
	}

}
