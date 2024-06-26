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
    private final Long timeout;

    public RequestQueue(Long timeout) {
        queue = new LinkedList<>();
        this.timeout = timeout;
    }

    public synchronized void send(String msg) {
        queue.add(msg);
        notifyAll();
    }

    public synchronized String get() throws InterruptedException {
        while (queue.isEmpty()) {
            wait(timeout);
        }

        return queue.poll();
    }
}
