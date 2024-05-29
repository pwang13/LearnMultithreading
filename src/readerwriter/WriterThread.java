package readerwriter;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class WriterThread extends Thread {
    private final Data data;
    private final String chars;

    public WriterThread(Data data, String chars) {
        this.data = data;
        this.chars = chars;
    }

    @Override
    public void run() {
        for (int i = 0; i < chars.length(); i++) {
            try {
                data.write(chars.charAt(i));
                Thread.sleep(800);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
