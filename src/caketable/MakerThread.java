package caketable;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Exchanger;

public class MakerThread implements Runnable {
//    private final Table table;
    private final BlockingQueue<Integer> blockingQueue;
    private static int val;

    public MakerThread(Table table, BlockingQueue<Integer> blockingQueue) {
//        this.table = table;
        this.blockingQueue = blockingQueue;
        val = 0;
    }

    @Override
    public void run() {
        while (true) {
            try {
//                table.put();
                int val = nextVal();
                blockingQueue.put(val);
                System.out.println(val + " put by : " + Thread.currentThread().getName() + " " + blockingQueue.size());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // interrupted status will be cleared once exception is thrown
                System.out.println(Thread.currentThread().isInterrupted());
            }
        }
    }

    private synchronized static int nextVal() {
        val++;
        return val;
    }
}
