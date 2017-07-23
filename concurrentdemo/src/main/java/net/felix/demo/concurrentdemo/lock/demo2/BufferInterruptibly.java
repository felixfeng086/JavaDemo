package net.felix.demo.concurrentdemo.lock.demo2;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by felix on 2017/5/17.
 */
public class BufferInterruptibly implements IBuffer {

    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void write() {
        lock.lock();
        try {
            Long startTime = System.currentTimeMillis();
            System.out.println("开始往Buffer写入数据...");
            for (; ; ) {
                if ((System.currentTimeMillis() - startTime) > Integer.MAX_VALUE)
                    break;
            }
            System.out.println("Buffer写入完毕！");
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void read() throws InterruptedException {
        lock.lockInterruptibly();// 注意这里，可以响应中断
        try {
            System.out.println("从Buffer读取数据...");
        } finally {
            lock.unlock();
        }
    }
}
