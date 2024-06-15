package synchronizaton;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class MyThread extends Thread {
    private final CountDownLatch downLatch;
    private final CyclicBarrier cyclicBarrier;
    private static final int phase = 5; // 5 steps

    public MyThread(CountDownLatch downLatch, CyclicBarrier cyclicBarrier) {
        this.downLatch = downLatch;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < phase; i++) {
                doPhase(i);
                cyclicBarrier.await();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            downLatch.countDown();
        }
    }

    private void doPhase(int i) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " " + i);
        Thread.sleep(new Random().nextInt(1000));
        System.out.println(Thread.currentThread().getName() + " " + i + " done");
    }
}
