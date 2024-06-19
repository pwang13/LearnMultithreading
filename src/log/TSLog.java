package log;

public class TSLog {
    private static ThreadLocal<LogWriter> threadLocal = new ThreadLocal<>();

    public static void write(String s) {
        LogWriter logWriter = threadLocal.get();
        if (logWriter == null) {
            logWriter = new LogWriter(Thread.currentThread().getName());
            threadLocal.set(logWriter);
            startWatcher(logWriter);
        }
        System.out.println(Thread.currentThread().getName() + " write: " + s);
        logWriter.write(s);
    }

    private static void startWatcher(LogWriter logWriter) {
        Thread currentThread = Thread.currentThread();

        Thread watcherThread = new Thread(() -> {
            System.out.println("watcher thread started on " + currentThread.getName());
            try {
                currentThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            logWriter.close();
        });
        watcherThread.start();
    }

}
