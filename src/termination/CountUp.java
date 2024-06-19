package termination;

import synchronizaton.Saver;

import java.util.concurrent.CountDownLatch;

public class CountUp extends Thread {
    private volatile boolean isShutDown = false;
    private int count;
    private final Saver saver;

    public CountUp(Saver saver) {
        count = 0;
        this.saver = saver;
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
            doShutDown();
        }
    }

    private void doShutDown() {
        System.out.println("shut down");
        saver.write(count);
    }
}
