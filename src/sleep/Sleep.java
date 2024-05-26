package sleep;

public class Sleep {
    public static void sleep(long x) throws InterruptedException {
        if (x != 0) {
            /**
             * use another object to make sure other thread will not notify the current thread
             */
            Object o = new Object();
            synchronized (o) {
                o.wait(x);
            }
        }
    }
}
