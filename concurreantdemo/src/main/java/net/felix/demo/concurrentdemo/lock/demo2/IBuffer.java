package net.felix.demo.concurrentdemo.lock.demo2;

/**
 * Created by felix on 2017/5/16.
 */
public interface IBuffer {
    public void write();
    public void read() throws InterruptedException;
}
