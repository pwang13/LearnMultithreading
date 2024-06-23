package activeobjectv2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        ActiveObjectImpl activeObject = new ActiveObjectImpl();
        Runnable runnable = () -> {
            int count = 0;
            while (true) {
                Future<String> stringFuture = activeObject.makeString(count, 'c');
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                try {
                    System.out.println(stringFuture.get());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                }
                count++;
            }
        };

        Runnable display = () -> {
            while (true) {
                activeObject.displayString("haha");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        };

        new Thread(runnable).start();
        new Thread(display).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        activeObject.shutdown();
        System.out.println("end of main");
    }
}
