package activeobjectv2;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ActiveObjectImpl implements ActiveObjectV2 {
    private ExecutorService executorService;

    public ActiveObjectImpl() {
        executorService = Executors.newFixedThreadPool(3);
    }

    @Override
    public Future<String> makeString(int count, char filler) {
        return executorService.submit(() -> {
            char[] c = new char[count];
            Arrays.fill(c, filler);
//            System.out.println("making: " + Arrays.toString(c) + " " + filler);
            Thread.sleep(100);
            return new String(c);
        });
    }

    @Override
    public void displayString(String s) {
        executorService.execute(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(s);
        });
    }

    @Override
    public void shutdown() {
        executorService.shutdown();
    }
}
