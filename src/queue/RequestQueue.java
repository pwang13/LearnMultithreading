package queue;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * guarded suspension pattern
 *
 * same as directly using LinkedBlockingQueue
 */
public class RequestQueue {
    private final Queue<String> queue;

    public RequestQueue() {
        queue = new LinkedList<>();
    }

    public synchronized void send(String msg) {
        queue.add(msg);
        notifyAll();
    }

    public synchronized String get() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }

        return queue.poll();
    }
}
