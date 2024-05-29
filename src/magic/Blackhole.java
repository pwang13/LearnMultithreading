package magic;

public class Blackhole {
    public static void enter(Object o) throws InterruptedException {
        System.out.println("1");
        magic(o);
        System.out.println("2");

        synchronized (o) {
            System.out.println("3 never reach");
        }
    }

    private static void magic(Object o) throws InterruptedException {
        Thread a = new Thread() {
            @Override
            public void run() {
                synchronized (o) {
                    synchronized (this) {
                        this.setName(""); // set name of thread a to empty so that we know obj o has been locked
                        notifyAll();
                    }

                    while (true) {}
                }
            }
        };

        synchronized (a) {
            a.start();
            while (!a.getName().isEmpty()) {
                a.wait();
            }
        }
    }
}
