package synchronizaton;

import termination.CountUp;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    /**
     * thread sync using
     * 1. count down latch: when task cannot be re-run, sync after run is finished
     * 2. cyclic barrier: when task can be re-run, sync after each run is finished
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        CountDownLatch count = new CountDownLatch(3);
        Runnable action = () -> System.out.println("action!");
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, action);
        MyThread myThread = new MyThread(count, cyclicBarrier);

        for (int i = 0; i < 3; i++) {
            executorService.execute(myThread);
        }

        count.await();
        System.out.println("main ends");
    }
}
