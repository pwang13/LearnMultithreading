package log;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LogWriter {
    private final PrintWriter printWriter;

    public LogWriter(String name) {
        try {
            printWriter = new PrintWriter(new FileWriter(name));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void write(String s) {
        printWriter.println(s);
    }

    public void close() {
        System.out.println("end of log");
        printWriter.close();
    }
}
