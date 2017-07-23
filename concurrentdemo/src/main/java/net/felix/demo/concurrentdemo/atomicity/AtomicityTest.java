package net.felix.demo.concurrentdemo.atomicity;

/**
 * @version 1.0.0
 * @auther felix
 * @since 2017/5/24
 * 通过使用syschronized、Lock、AtomicInteger保证自增操作的原子性
 */
public class AtomicityTest {


    public static void main(String[] args) {

        int atomicityFlag = 3;//0:未使用原子操作 1：使用syschronized保证原子性 2：使用Lock保证原子性 3：使用AtomicInteger保证原子性

        AtomicitySuper atomicity;

        if (atomicityFlag == 1) {
            atomicity = new AtomisityBySynchronized();
        } else if (atomicityFlag == 2) {
            atomicity = new AtomisityByLock();
        } else if (atomicityFlag == 3) {
            atomicity = new AtomisityByAtomicInteger();
        } else {
            atomicity = new AtomicitySuper();
        }

        for (int i = 0; i < 10; i++) {
            new Thread() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        atomicity.increase();
                    }
                }
            }.start();
        }

        //保证前面的线程都执行完
        while (Thread.activeCount() > 2) {
//            if (Thread.activeCount() == 3) {
//                System.out.println("inc累计=" + atomicity.inc);
//            }
            Thread.yield();//使当前线程从执行状态（运行状态）变为可执行态（就绪状态）
        }

        System.out.println("inc累计=" + atomicity.inc);
    }
}
