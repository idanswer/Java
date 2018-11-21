package com.pxy.crazyPoolManager.thread;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
//import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ThreadUtil {
	public static List<Object> runCheckCallable(List<Callable<Object>> threadList,boolean isBlock) throws InterruptedException, ExecutionException  {
		if(threadList==null||threadList.size()<1) {
			return new ArrayList<>();
		}
		for(Callable<Object> callable : threadList) {
			if(callable==null)
				return new ArrayList<>();
		}
		ExecutorService exec = Executors.newCachedThreadPool();
		List<Future<Object>> futureList = exec.invokeAll(threadList);
		//Èç¹ûÎªfalse
		if(!isBlock) {
			Object future = exec.invokeAny(threadList);
			List<Object> returnOneValue = new ArrayList<>(1);
			returnOneValue.add(future);
			return returnOneValue;
		}
//		return getAllCallableReturn(futureList);
		return getAllCallableReturn(futureList);
	}

	private static List<Object> getAllCallableReturn(List<Future<Object>> futureList) throws InterruptedException, ExecutionException {
		List<Object> returnValue = new ArrayList<>(futureList.size());
		while(true) {
			Iterator<Future<Object>> iterator = futureList.iterator();
			while(iterator.hasNext()) {
				Future<Object> future = iterator.next();
				if(future.isDone()) {
					Object o = future.get();
					returnValue.add(o);
					iterator.remove();
				}
			}
			if(futureList.size()==0) {
				break;
			}
			TimeUnit.SECONDS.sleep(10);
		}
		return returnValue;
	}
}
