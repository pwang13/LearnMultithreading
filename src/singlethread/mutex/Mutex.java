package singlethread.mutex;

// implementation of synchronized
public class Mutex {
    private boolean isBusy;
    private String currentThread;

    public Mutex() {
        isBusy = false;
    }

    // lock
    public synchronized void lock() throws InterruptedException {
        while (isBusy && !currentThread.equals(Thread.currentThread().getName())) {
            wait();
        }
        isBusy = true;
        currentThread = Thread.currentThread().getName();
    }

    // unlock
    public synchronized void unlock() {
        // prevent other threads to unlock current thread
        if (currentThread.equals(Thread.currentThread().getName())) {
            isBusy = false;
            notifyAll();
            currentThread = null;
        }
    }
}
