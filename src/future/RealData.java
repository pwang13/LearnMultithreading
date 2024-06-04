package future;

import java.util.Random;

public class RealData {
    private String result;

    public String fetchContent() throws InterruptedException {
        int id = new Random().nextInt(2000);
        System.out.println(Thread.currentThread().getName() + " fetching " + id);
        Thread.sleep(id);
        System.out.println(Thread.currentThread().getName() + " fetched " + id);
        result = String.valueOf(id);
        return result;
    }

    public String getResult() {
        return result;
    }
}
