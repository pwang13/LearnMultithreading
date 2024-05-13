package singlethread.mutex;

public class Main {
    public static void main(String[] args) {
        Mutex mutex = new Mutex();
        for (int i = 0; i < 100; i++) {
            TestThread testThread = new TestThread(mutex);
            new Thread(testThread).start();
        }
    }
}
