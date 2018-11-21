package com.pxy.crazyPoolManager.thread;

//import com.pxy.demo.utils.ThreadUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * ���ڷ�ˮ��
 * Created by captain on 2017/7/27.
 */
public class WaterTimeTask extends TimerTask {

    @Override
    public void run() {
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(10000);
        InputThread thread1 = new InputThread(queue);
        OutputThread thread2 = new OutputThread(queue);
        List<Callable<Object>> threadList = new ArrayList<>(2);
        threadList.add(thread1);
        threadList.add(thread2);
        List<Object> returnValue = null;
        try {
            returnValue = ThreadUtil.runCheckCallable(threadList,true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Ӿ���Ѿ�ע��");
        Iterator<Object> iterator = returnValue.iterator();
        while(true){
        	if(iterator.hasNext()) {
        		System.out.println(iterator.next());
        	}
        	else
        		break;
        }
    }
}
