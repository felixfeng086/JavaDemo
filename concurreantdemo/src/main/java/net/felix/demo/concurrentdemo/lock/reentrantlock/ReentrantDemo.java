package net.felix.demo.concurrentdemo.lock.reentrantlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 对于重入锁而言，"lock"和"keep"是两个不同的概念。lock了锁，不一定keep锁，但keep了锁一定已经lock了锁
 */
public class ReentrantDemo {
    public static void main(String[] args) throws InterruptedException {
        final ExecutorService exec = Executors.newFixedThreadPool(4);
        final ReentrantLock lock = new ReentrantLock();
        final Condition con = lock.newCondition();
        final int time = 5;
        final Runnable add = new Runnable() {
            public void run() {
                System.out.println("Pre " + lock);
                lock.lock();
                try {
//                    con.await(time, TimeUnit.SECONDS);
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("Post " + lock.toString());
                    lock.unlock();
                }
            }
        };
        for (int index = 0; index < 4; index++)
            exec.submit(add);
        exec.shutdown();
    }
}
