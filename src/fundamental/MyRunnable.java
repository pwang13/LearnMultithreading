package fundamental;

public class MyRunnable implements Runnable {
    private final String message;

    public MyRunnable(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(message);
        }
    }
}
