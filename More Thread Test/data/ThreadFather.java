package com.pxy.marix.thread;

public class ThreadFather {
	protected	int[][] a;
	protected   int[][] b;
	protected static int[][] c =new int[1000][1000];
	ThreadFather(int[][] a,int[][] b) {
		this.a=a;
		this.b=b;
	}
	public void MatrixMul(int i1,int m,int j1,int n) {
		for(int i=i1;i<m;i++)
			for(int j=j1;j<n;j++)
				for(int k=0;k<b.length;k++)
					c[i][j]+=a[i][k]*b[k][j];
	}
}
