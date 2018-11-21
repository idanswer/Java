package com.pxy.marix.thread;

import java.util.concurrent.Callable;

public class Thread1 extends ThreadFather implements Callable<String> {
	public Thread1(int[][] a,int[][]b) {
		super(a,b);
	}
	
	@Override
	public String call() throws Exception {
//		double firstTime=System.currentTimeMillis();
		MatrixMul(0,a.length/4,0,b[0].length/4);
		return "success";
//		double lastTime=System.currentTimeMillis();
//		Double dertTime=lastTime-firstTime;
//		return dertTime.toString();
	}
//	@Override
//	public void run() {
//		double firstTime=System.currentTimeMillis();
//		for(int i=0;i<(a.length/2);i++)
//			for(int j=0;j<b[0].length;j++)
//				for(int k=0;k<a[0].length;k++)
//					c[i][j]+=a[i][k]*b[k][j];
//		double lastTime=System.currentTimeMillis();
//		System.out.println(firstTime+"/n"+lastTime);
//	}
	
}
