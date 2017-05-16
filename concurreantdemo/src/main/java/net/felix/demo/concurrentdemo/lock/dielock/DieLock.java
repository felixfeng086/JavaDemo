package net.felix.demo.concurrentdemo.lock.dielock;

/**
 * Created by felix on 2017/5/12.
 */
public class DieLock extends Thread {

    private boolean flag;

    public DieLock(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag) {
            synchronized (MyLock.objA) {
                System.out.println("if objA");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (MyLock.objB) {
                System.out.println("if objB");
            }
        } else {
            synchronized (MyLock.objA) {
                System.out.println("else objA");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (MyLock.objB) {
                System.out.println("else objB");
            }
        }
    }
}
