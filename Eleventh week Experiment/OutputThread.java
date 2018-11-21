package com.pxy.crazyPoolManager.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * ��ˮ�߳�
 * Created by captain on 2017/7/27.
 */
public class OutputThread implements Callable<Object>{

    private BlockingQueue<String> queue;

    public OutputThread(BlockingQueue queue){
        this.queue = queue;
    }

    @Override
    public Object call() throws InterruptedException {
        while(true){
            if(queue.size()>=50){
                break;
            }
            for(int cnt=0;cnt<3;cnt++){
                queue.poll(10,TimeUnit.SECONDS);
            }
            System.out.println("��ˮ3�����ף���ǰˮ����"+queue.size());
            TimeUnit.SECONDS.sleep(1);
        }
        return "success";
    }
}
