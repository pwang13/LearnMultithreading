package log;

public class SaverThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            TSLog.write(String.valueOf(i));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        /**
         * further decouple by starting a watcher thread in log writer to automatically close after thread finished
         */
//        TSLog.close();
    }
}
