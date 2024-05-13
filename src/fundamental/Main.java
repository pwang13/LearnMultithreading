package fundamental;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class Main {
    public static void main(String[] args) {
        // create thread
        MyThread t1 = new MyThread();

        MyRunnable r1 = new MyRunnable("run");

        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        MyRunnable r2 = new MyRunnable("factory");

        t1.start();
        new Thread(r1).start();
        threadFactory.newThread(r2).start();

        for (int i = 0; i < 10; i++) {
            System.out.println("main");
        }

        // synchronize
        SynchronizedBank synchronizedBank = new SynchronizedBank();

    }
}


