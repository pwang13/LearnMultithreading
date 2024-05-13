package singlethread.deadlock;

public class UserThread implements Runnable {
    public final String name;
    private final Tool fork, knife;

    public UserThread(String name, Tool fork, Tool knife) {
        this.name = name;
        this.fork = fork;
        this.knife = knife;
    }

    @Override
    public void run() {
        synchronized (fork) {
            System.out.println(Thread.currentThread().getName() + " lock fork");
            synchronized (knife) {
                System.out.println(Thread.currentThread().getName() + " lock knife");
            }
        }
    }
}
