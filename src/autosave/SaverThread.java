package autosave;

import java.util.Random;

public class SaverThread implements Runnable {
    private final Data data;
    private final Random random;

    public SaverThread(Data data) {
        this.data = data;
        random = new Random();
    }

    @Override
    public void run() {
        for (;;) {
            try {
                data.save();
                Thread.sleep(random.nextInt(200));
            } catch (Exception e) {
                System.out.println("failed to save: " + e.getMessage());
            }
        }
    }
}
