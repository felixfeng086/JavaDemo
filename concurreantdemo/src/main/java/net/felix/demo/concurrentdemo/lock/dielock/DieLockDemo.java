package net.felix.demo.concurrentdemo.lock.dielock;

/**
 * Created by felix on 2017/5/12.
 */
public class DieLockDemo {

    public static void main (String[] args) {
        DieLock d1 = new DieLock(true);
        DieLock d2 = new DieLock(false);
        d1.start();
        d2.start();
    }
}
