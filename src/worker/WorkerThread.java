package worker;

public class WorkerThread extends Thread {
    private final Channel channel;

    public WorkerThread(Channel channel) {
        this.channel = channel;
    }

    @Override
    public void run() {
        while(true) {
            Request request = null;
            try {
                request = channel.getRequest();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            request.run();
        }

    }
}
