package net.felix.demo.concurrentdemo.atomicity;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @version 1.0.0
 * @auther felix
 * @since 2017/5/24
 */
public class AtomisityByAtomicInteger extends AtomicitySuper {
    public AtomicInteger atomInc = new AtomicInteger(1);
    @Override
    public void increase() {
        inc = atomInc.getAndIncrement();
    }
}
