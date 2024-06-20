package activeobject;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SchedulerThread extends Thread {
    private final RequestQueue requestQueue;
    private final ExecutorService executorService;

    public SchedulerThread(RequestQueue requestQueue) {
        this.requestQueue = requestQueue;
        executorService = Executors.newFixedThreadPool(3);
    }

    public void putRequest(MethodRequest methodRequest) {
        requestQueue.putRequest(methodRequest);
    }

    @Override
    public void run() {
        try {
            while (true) {
                executorService.execute(() -> {
                    requestQueue.getRequest().execute();
                });
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
