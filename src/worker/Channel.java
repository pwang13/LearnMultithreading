package worker;

import java.util.LinkedList;
import java.util.Queue;

public class Channel {
    private final Thread[] threads;
    private final Queue<Request> requests;

    public Channel(int capacity) {
        threads = new Thread[capacity];

        for (int i = 0; i < capacity; i++) {
            WorkerThread workerThread = new WorkerThread(this);
            threads[i] = workerThread;
            workerThread.start();
        }

        this.requests = new LinkedList<>();
    }

    public synchronized void putRequest(Request request) {
        requests.offer(request);
        notifyAll();
    }

    public synchronized Request getRequest() throws InterruptedException {
        if (requests == null || requests.isEmpty()) {
            wait();
        }
        return requests.poll();
    }
}
