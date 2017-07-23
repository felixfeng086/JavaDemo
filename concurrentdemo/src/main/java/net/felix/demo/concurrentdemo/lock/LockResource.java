package net.felix.demo.concurrentdemo.lock;

import java.util.concurrent.locks.Lock;

/**
 * Created by felix on 2017/5/16.
 */
public class LockResource implements AutoCloseable {

    private final Lock mLock;

    public LockResource(Lock lock) {
        this.mLock = lock;
        mLock.lock();
    }

    @Override
    public void close() {
        mLock.unlock();
    }
}
