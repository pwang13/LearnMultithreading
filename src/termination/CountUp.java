package termination;

import java.util.concurrent.CountDownLatch;

public class CountUp extends Thread {
    private final CountDownLatch latch;
    private volatile boolean isShutDown = false;
    private int count;

    public CountUp(CountDownLatch latch) {
        count = 0;
        this.latch = latch;
    }

    public void shutdown() {
        isShutDown = true;
        interrupt();
    }

    @Override
    public void run() {
        try {
            while (!isShutDown) {
                System.out.println(count);
                count++;

                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("handle interruption");
        } finally {
            shutdown();
            latch.countDown();
            System.out.println("shut down");
        }
    }
}
