package future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ClientThread extends Thread {
    private final Channel channel;

    public ClientThread(Channel channel) {
        this.channel = channel;
    }

    @Override
    public void run() {

//        RealData realData = new RealData();
//        FutureData futureData = channel.submit(realData);
//
//        RealData realData1 = new RealData();
//        FutureData futureData1 = channel.submit(realData1);
//        System.out.println("do other things");
//        try {
//            System.out.println(channel.get(futureData));
//            System.out.println(channel.get(futureData1));
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        ExecutorService service = Executors.newFixedThreadPool(4);
        Future<String> future = service.submit(() -> new RealData().fetchContent());
        System.out.println("do other things");
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
