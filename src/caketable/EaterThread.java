package caketable;

import javax.management.relation.RelationNotFoundException;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class EaterThread implements Runnable {
    private final Table table;
    private final Random random;
    private final BlockingQueue<Integer> blockingQueue;

    public EaterThread(Table table, BlockingQueue blockingQueue) {
        this.table = table;
        random = new Random(100);
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            table.get();
            try {
                int val = blockingQueue.take();
                System.out.println(val + " take by : " + Thread.currentThread().getName() + " " + blockingQueue.size());
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
