package net.felix.demo.concurrentdemo.lock.demo2;

/**
 * Created by felix on 2017/5/17.
 */
public class Buffer implements IBuffer {

    private Object lock;

    public Buffer() {
        lock = this;
    }

    @Override
    public void write() {
        synchronized (lock) {
            Long startTime = System.currentTimeMillis();
            System.out.println("开始往Buffer写入数据...");
            for (; ; ) {
                if ((System.currentTimeMillis() - startTime) > Integer.MAX_VALUE)
                    break;
            }
            System.out.println("Buffer写入完毕！");
        }
    }

    @Override
    public void read() throws InterruptedException {
        synchronized (lock) {
            System.out.println("从Buffer读取数据");
        }
    }
}
