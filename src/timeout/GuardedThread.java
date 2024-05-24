package timeout;

import java.util.concurrent.TimeoutException;

public class GuardedThread implements Runnable {
    private final Long timeout;
    private boolean isReady;
    public GuardedThread(Long timeout) {
        this.timeout = timeout;
        isReady = false;
    }

    public synchronized void doExecute() {
        System.out.println("changed to executable: " + Thread.currentThread().getName());
        isReady = true;
        notifyAll();
    }

    @Override
    public void run() {
        synchronized (this) {
            System.out.println("run: " + Thread.currentThread().getName());
            long timestamp = System.currentTimeMillis();
            while (!isReady) {
                long cur = System.currentTimeMillis();
                if (cur - timestamp > timeout) {
                    throw new RuntimeException("timeout!");
                }
                long rest = timeout - (cur - timestamp);
                try {
                    System.out.println("wait for " + rest);
                    wait(rest);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            System.out.println("executing");
        }
    }
}
