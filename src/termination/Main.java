package termination;

import java.util.concurrent.CountDownLatch;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        /**
         * shutdown a thread using two phase termination
         */
//        CountUp countUp = new CountUp();
//        System.out.println(Thread.currentThread().getName() + " start");
//        countUp.start();
//        Thread.sleep(1000);
//        System.out.println(Thread.currentThread().getName() + " shutdown");
//        countUp.shutdown();
//        countUp.join();
//        System.out.println(Thread.currentThread().getName() + " end");

        /**
         * shut down gracefully
         * 1. register uncaught exception handler
         * 2. use shut down hook
         */
//        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
//            @Override
//            public void uncaughtException(Thread t, Throwable e) {
//                System.out.println("get throwable " + e);
//                System.out.println("current thread " + Thread.currentThread().getName());
//                System.out.println("exception thread: " + t);
//            }
//        });
//
//        Runtime.getRuntime().addShutdownHook(new Thread("shutdown-hook") {
//            @Override
//            public void run() {
//                System.out.println("shutting down");
//                System.out.println("current thread: " + Thread.currentThread().getName());
//            }
//        });
//
//        Thread a = new Thread("my-exception") {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().isInterrupted());
//                try {
//                    Thread.sleep(10000);
//                } catch (InterruptedException e) {
//                    System.out.println("interrupted");
//                    throw new RuntimeException(e);
//                }
//
//            }
//        };
//
//        a.interrupt();
//        a.start();
//        Thread.sleep(100);
//




    }
}
