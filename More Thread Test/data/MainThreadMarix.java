package com.pxy.marix.thread;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainThreadMarix {
//	@SuppressWarnings("null")
	public static void main(String[] args) {
		Random random=new Random();
		int count=1000;
		int[][] a=new int[count][count];
		int[][] b=new int[count][count];
//		int[][] c=new int[count][count];
		for(int i=0;i<count;i++) {
			for(int j=0;j<count;j++) {
				int m=random.nextInt(10)*(random.nextInt()>0?1:-1);
				int n=random.nextInt(10)*(random.nextInt()>0?1:-1);
				a[i][j]=m;
				b[i][j]=n;
			}
		}
		Thread1 t1=new Thread1(a,b);
		Thread2 t2=new Thread2(a,b);
		Thread3 t3=new Thread3(a,b);
		Thread4 t4=new Thread4(a,b);
		Thread5 t5=new Thread5(a,b);
		Thread6 t6=new Thread6(a,b);
		Thread7 t7=new Thread7(a,b);
		Thread8 t8=new Thread8(a,b);
		Thread9 t9=new Thread9(a,b);
		Thread10 t10=new Thread10(a,b);
		Thread11 t11=new Thread11(a,b);
		Thread12 t12=new Thread12(a,b);
		Thread13 t13=new Thread13(a,b);
		Thread14 t14=new Thread14(a,b);
		Thread15 t15=new Thread15(a,b);
		Thread16 t16=new Thread16(a,b);
		List<Callable<String>> ThreadList= new ArrayList<>();
		ThreadList.add(t1);
		ThreadList.add(t2);
		ThreadList.add(t3);
		ThreadList.add(t4);
		ThreadList.add(t5);
		ThreadList.add(t6);
		ThreadList.add(t7);
		ThreadList.add(t8);
		ThreadList.add(t9);
		ThreadList.add(t10);
		ThreadList.add(t11);
		ThreadList.add(t12);
		ThreadList.add(t13);
		ThreadList.add(t14);
		ThreadList.add(t15);
		ThreadList.add(t16);
//		List<String> returnValues=new ArrayList<String>(ThreadList.size());
		ExecutorService exec = Executors.newCachedThreadPool();
		List<Future<String>> futureList = null;
		try {
			double firstTime=System.currentTimeMillis();
			futureList = exec.invokeAll(ThreadList);
			double lastTime=System.currentTimeMillis();
			System.out.println("Ê±¼äÎª£º"+(lastTime-firstTime));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		Iterator<Future<String>> iterator = futureList.iterator();
//		while(iterator.hasNext()) {
//			Future<String> future=iterator.next();
//			if(future.isDone()) {
//				String d;
//				try {
//					d = future.get();
//					returnValues.add(d);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (ExecutionException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//				iterator.remove();
//			}
//		}
//		Iterator<String> iterator2 = returnValues.iterator();
//        while(true){
//        	if(iterator2.hasNext()) {
//        		System.out.println(iterator2.next());
//        	}
//        	else
//        		break;
//        }
////		System.out.println(t1.getDertTime()+t2.getDertTime());
	}
}
