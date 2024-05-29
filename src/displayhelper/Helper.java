package displayhelper;

import java.util.Random;

public class Helper {
    private final Random random;

    public Helper() {
        random = new Random(1000);
    }

    public void handle(String msg) throws InterruptedException {
        Thread.sleep(random.nextInt(1000));
        System.out.println(Thread.currentThread().getName() + " " + msg);
    }

    public void anotherHandle(String msg) {
        Thread executor = new Thread(() -> {
            try {
                Thread.sleep(random.nextInt(1000));
                System.out.println("another: " + Thread.currentThread().getName() + " " + msg);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        executor.start();
    }
}
