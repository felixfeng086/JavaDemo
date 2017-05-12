package net.felix.demo.concurrentdemo.threadpool;

/**
 * Created by felix on 2017/5/11.
 */
public class MyThread extends Thread{
    public void run() {
        System.out.println(Thread.currentThread().getName() + "正在执行...");
    }
}
