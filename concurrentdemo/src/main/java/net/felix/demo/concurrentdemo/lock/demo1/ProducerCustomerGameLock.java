package net.felix.demo.concurrentdemo.lock.demo1;

import net.felix.demo.concurrentdemo.lock.LockResource;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by felix on 2017/5/12.
 */
public class ProducerCustomerGameLock {

    public static void main(String[] args) {
        Bucket bucket = new Bucket();
        new Thread(new Producer(bucket), "producer线程").start();
        new Thread(new Constumer(bucket), "constumer线程").start();
    }
}


final class Constumer implements Runnable {
    private Bucket bucket;

    public Constumer(Bucket bucket) {
        this.bucket = bucket;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            bucket.get();
        }
    }
}

final class Producer implements Runnable{
    private Bucket bucket;

    public Producer(Bucket bucket) {
        this.bucket = bucket;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            bucket.put((int)(Math.random()*1000));
        }
    }
}


class Bucket {
    private volatile int packOdBalls;
    private volatile boolean available = false;
    private final ReentrantLock lock = new ReentrantLock();
    private Condition noBall = lock.newCondition();
    private Condition fullBall = lock.newCondition();

    public int get() {//消费者从篮子里面取出来
        try (LockResource r = new LockResource(lock)){
            if (available == false) {
                System.out.println("消费者：暂时没有球，我先等着...");
                noBall.await();
            }
            System.out.println("消费者获得了" + packOdBalls + "个球");
            available = false;
            System.out.println("持有消费线程数" + lock.getHoldCount());
            fullBall.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return packOdBalls;//取出球的个数
    }

    public void put(int pack0dballs) {
        try (LockResource r = new LockResource(lock)) {
            if (available) {
                System.out.println("生产者：既然篮子里面已经有球了我就消费完了再生产吧！");
                fullBall.await();
            }
            this.packOdBalls = pack0dballs;
            available = true;
            System.out.println("生产者放进去了" + packOdBalls + "个球");
            noBall.signal();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
