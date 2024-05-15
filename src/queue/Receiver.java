package queue;

public class Receiver extends Thread {
    private final RequestQueue requestQueue;

    public Receiver(RequestQueue requestQueue) {
        this.requestQueue = requestQueue;
    }

    @Override
    public void run() {
        while(true) {
            try {
                String msg = requestQueue.get();
                System.out.println(Thread.currentThread().getName() + " get: " + msg);
            } catch (Exception e) {
                System.out.println(Thread.currentThread().getName() + " failed " + e.getMessage());
                break;
            }
        }
    }
}
