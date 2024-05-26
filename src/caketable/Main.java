package caketable;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    /**
     * 三种生产者消费者的实现
     * 1. 使用 table 作为 channel 并实现的互斥
     * 2. 使用 concurrent 包中的 blocking queue 作为channel 实现互斥
     * 3. 使用 exchange 类实现同步的数据传递
     *
     * @param args
     */
    public static void main(String[] args) {
        Table table = new Table(3);
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(3);
        MakerThread makerThread = new MakerThread(table, blockingQueue);
        EaterThread eaterThread = new EaterThread(table, blockingQueue);

        Thread interruptableThread = new Thread(makerThread);
        interruptableThread.start();
        new Thread(makerThread).start();
        new Thread(eaterThread).start();

        interruptableThread.interrupt();
    }
}
