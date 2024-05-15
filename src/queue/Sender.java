package queue;

public class Sender extends Thread {
    private final RequestQueue queue;

    public Sender(RequestQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " send: " + i);
            queue.send(String.valueOf(i));
        }
    }
}
