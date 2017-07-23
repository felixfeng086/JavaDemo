package net.felix.demo.concurrentdemo.lock.reentrantlock;

/**
 * Created by felix on 2017/5/12.
 */
public class ReentrantLockTest {

    public static void main(String[] args) {
        SellTicketRunable sellTicket = new SellTicketRunable();
        Thread tr1 = new Thread(sellTicket, "窗口1");
        Thread tr2 = new Thread(sellTicket, "窗口2");
        Thread tr3 = new Thread(sellTicket, "窗口3");
        Thread tr4 = new Thread(sellTicket, "窗口4");
        Thread tr5 = new Thread(sellTicket, "窗口5");

        tr1.start();
        tr2.start();
        tr3.start();
        tr4.start();
        tr5.start();
    }
}
