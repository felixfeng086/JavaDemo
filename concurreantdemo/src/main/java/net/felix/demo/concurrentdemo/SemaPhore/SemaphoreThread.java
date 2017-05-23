package net.felix.demo.concurrentdemo.SemaPhore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import static sun.misc.PostVMInitHook.run;

/**
 * Created by felix on 2017/5/23.
 */
public class SemaphoreThread {
    private int a = 0;

    /**
     * 银行存钱类
     */
    class Bank {
        private int acount = 100;

        public int getAcount() {
            return this.acount;
        }

        public void save(int money) {
            this.acount += money;
        }
    }

    /**
     * 线程执行类，每个人随机存入一定量的钱
     */
    class NewThread implements Runnable {
        private Bank bank;
        private Semaphore semaphore;

        public NewThread(Bank bank, Semaphore semaphore) {
            this.bank = bank;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            int b = a++;
            if (semaphore.availablePermits() > 0) {
                System.out.println("线程" + b + "启动，进入银行窗口，立即进行存钱");
            } else {
                System.out.println("线程" + b + "启动，窗口忙，继续等待");
            }
            try {
                semaphore.acquire();
                bank.save((int)(Math.random()*10000));
                Thread.sleep(5000);
                System.out.println("线程" + b + "存钱完毕，离开银行，" + " 账户余额为：" + bank.getAcount());
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //建立线程，使用内部类，开始存钱
    public void useThread() {
        Bank bank = new Bank();
        //定义10个信号量
        Semaphore semaphore = new Semaphore(5);
        //建立一个缓存线程池
        ExecutorService ex = Executors.newCachedThreadPool();
        //建立20个线程
        for (int i = 0; i < 20; i++) {
            //执行一个线程
            ex.submit(new Thread(new NewThread(bank, semaphore)));
        }
        //关闭线程池
        ex.shutdown();

        //从信号量中获得两个许可，并且在获得许可之前，一直将线程阻塞
        semaphore.acquireUninterruptibly(2);
        System.out.println("到点了，两个窗口的工作人员要去吃饭了");
        System.out.println("可用许可为：" + semaphore.availablePermits());
        //释放两个许可，并将其返回给信号量
        semaphore.release(2);
    }

    public static void main(String[] args) {
        SemaphoreThread semaphoreThread = new SemaphoreThread();
        semaphoreThread.useThread();
    }
}
