package net.felix.demo.concurrentdemo.atomicity;

/**
 * @version 1.0.0
 * @auther felix
 * @since 2017/5/24
 */
public class AtomisityBySynchronized extends AtomicitySuper {
    @Override
    public synchronized void increase() {
        inc++;
    }
}
