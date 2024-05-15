package autosave;

import java.util.Random;

public class ChangerThread implements Runnable {
    private final Data data;
    private final Random random;

    public ChangerThread(Data data) {
        this.data = data;
        this.random = new Random();
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            data.change(String.valueOf(i));
            try {
                Thread.sleep(random.nextInt(100));
                data.save();
            } catch (Exception e) {
                System.out.println("failed to save in changer: " + e.getMessage());
            }
        }
    }
}
