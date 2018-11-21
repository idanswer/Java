package com.pxy.crazyPoolManager.thread;

import java.util.Calendar;
import java.util.Timer;
/**
 * Created by captain on 2017/7/27.
 */
public class MainDrive {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DATE),
                9,47,30
        );
        WaterTimeTask task = new WaterTimeTask();
        Timer timer = new Timer();
//        timer.scheduleAtFixedRate(task, 5000, 1000*60*60*24);//延迟5秒执行
        timer.schedule(task,calendar.getTime(),1000*60*60*24);//每天8点执行
    }
}
