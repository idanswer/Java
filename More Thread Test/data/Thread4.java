package com.pxy.marix.thread;

import java.util.concurrent.Callable;

public class Thread4 extends ThreadFather implements Callable<String> {
	
	Thread4(int[][] a, int[][] b) {
		super(a, b);
	}
	
	@Override
	public String call() throws Exception {
		MatrixMul(0,a.length/4,b[0].length*4/3,b[0].length);
		return null;
	}

}
