package net.felix.demo.concurrentdemo.lock.reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by felix on 2017/5/12.
 */
public class SellTicketRunable implements Runnable {

    //定义票
    private int tickets = 100;

    //定义锁对象
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        for (; ; ) {
            if (tickets == 0) {
                break;
            }
            try {
                //加锁
                lock.lock();
                if (tickets > 0) {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + "正在出售第" + (tickets--) + "张票");
                } else {
                    System.out.println("票已售完");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                //释放锁
                lock.unlock();
            }
        }
    }
}
