package synchronizaton;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Saver {
    private final static PrintWriter printWriter;

    static {
        try {
            printWriter = new PrintWriter("log");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void write(int counter) {
        System.out.println(Thread.currentThread().getName() + " write: " + counter);
        printWriter.write(Thread.currentThread().getName() + " " + counter);
    }
}
