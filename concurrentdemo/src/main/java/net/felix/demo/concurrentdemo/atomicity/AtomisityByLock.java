package net.felix.demo.concurrentdemo.atomicity;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @version 1.0.0
 * @auther felix
 * @since 2017/5/24
 */
public class AtomisityByLock extends AtomicitySuper {
    private ReentrantLock lock = new ReentrantLock();
    @Override
    public void increase() {
        lock.lock();
        try {
            inc++;
        } finally {
            lock.unlock();
        }
    }
}
