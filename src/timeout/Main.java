package timeout;

public class Main {
    public static void main(String[] args) {
        GuardedThread guardedThread = new GuardedThread(1000L);
        Thread thread = new Thread(guardedThread);
        thread.start();
        guardedThread.doExecute();
    }
}
