package com.pxy.crazyPoolManager.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * עˮ�߳�
 * Created by captain on 2017/7/27.
 */
public class InputThread implements Callable<Object>{

    private BlockingQueue<String> queue;

    public InputThread(BlockingQueue queue){
        this.queue = queue;
    }

    @Override
    public Object call() throws InterruptedException {
        while(true){
            boolean flag = true;
            for(int cnt=0;cnt<5;cnt++){
                flag = queue.offer("һ������");
                if(!flag){
                    break;
                }
            }
            System.out.println("עˮ5�����ף���ǰˮ����"+queue.size());
            if(queue.size()>=50)
            	break;
//            if(!flag){
//                break;
//            }
            TimeUnit.SECONDS.sleep(1);
        }
        return "success";
    }
}