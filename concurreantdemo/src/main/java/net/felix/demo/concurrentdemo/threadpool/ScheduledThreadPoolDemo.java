package net.felix.demo.concurrentdemo.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 创建一个定长线程池，支持定时及周期性任务执行。
 */
public class ScheduledThreadPoolDemo {
    public static void main(String[] args) throws InterruptedException{
        ScheduledExecutorService scheduledExecutorPool = Executors.newScheduledThreadPool(5);
        scheduledExecutorPool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("delay 3 seconds，" + Thread.currentThread().getName());
            }
        }, 3, TimeUnit.SECONDS);

//        Thread.sleep(5000);
        scheduledExecutorPool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("excute every 3 seconds，" + Thread.currentThread().getName());
            }
        },5,3,TimeUnit.SECONDS);

    }
}
