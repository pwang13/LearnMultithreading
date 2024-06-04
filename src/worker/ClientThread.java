package worker;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientThread extends Thread {
    private final ExecutorService executorService;

    public ClientThread(ExecutorService executorService) {
        this.executorService = executorService;

    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Request request = new Request();
            executorService.execute(request);
        }
    }
}
