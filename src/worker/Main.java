package worker;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    /**
     * worker 模式，也可以理解为线程池模式，channel 使用了 consumer producer 模式管理 worker
     * 也可以使用 concurrent 类种的fixed thread pool
     * @param args
     */
    public static void main(String[] args) {
//        Channel channel = new Channel(5);
//        for (int i = 0; i < 10; i++) {
//            Request request = new Request();
//            channel.putRequest(request);
//        }

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        try {
            ClientThread clientThread = new ClientThread(executorService);
            clientThread.start();
            clientThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("shutting down");
            executorService.shutdown();
        }

    }
}
