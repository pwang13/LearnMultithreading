package worker;

public class Request implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " working..");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " done..");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
