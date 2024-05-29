package readerwriter;

import java.util.Arrays;
import java.util.Random;

public class ReaderThread extends Thread {
    private final Data data;
    private final Random random;

    public ReaderThread(Data data) {
        this.data = data;
        random = new Random(100);
    }

    @Override
    public void run() {
        for(;;) {
            try {
                char[] val = data.read();
                System.out.println(Thread.currentThread().getName() +  " read: " + Arrays.toString(val));
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
