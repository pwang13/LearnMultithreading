package log;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<SaverThread> saverThreads = new LinkedList<>();

        for (int i = 0; i < 3; i++) {
            saverThreads.add(new SaverThread());
        }

        saverThreads.forEach(s -> s.start());
        saverThreads.forEach(s -> {
            try {
                s.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

    }
}
