package net.felix.demo.concurrentdemo.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待
 * 因为线程池大小为系统可用CPU数，每个任务输出index后sleep 2秒，所以每两秒打印可用CPU数个数字。
 * 定长线程池的大小最好根据系统资源进行设置。如Runtime.getRuntime().availableProcessors()。可参考PreloadDataCache。
 */
public class FixedThreadPoolDemo {
    public static void main(String args[]) {
        int processors = Runtime.getRuntime().availableProcessors();
        System.out.println("系统处理器数量为：" + processors + "，因此每次执行" + processors + "个线程...");
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(processors);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            fixedThreadPool.execute(new Runnable() {
                public void run() {
                    System.out.println(index);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        fixedThreadPool.shutdown();
    }
}
