package mutex;

public class TestThread implements Runnable{
    private final Mutex mutex;

    public TestThread(Mutex mutex) {
        this.mutex = mutex;
    }

    @Override
    public void run() {
        try {
            mutex.lock();
            // reentrant
            mutex.lock();
            System.out.println(Thread.currentThread().getName() + " acquired lock");
        } catch (Exception e) {
            System.out.println("interrupted " + e.getMessage());
        } finally {
            mutex.unlock();
        }
    }
}
