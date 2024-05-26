package caketable;

public class Table {
    private final int size;
    private int itemSize;

    public Table(int size) {
        this.size = size;
        itemSize = 0;
    }

    public synchronized void put() throws InterruptedException {
        while (itemSize == size) {
            System.out.println("wait by: " + Thread.currentThread().getName());
            wait();
        }

        System.out.println("put by: " + Thread.currentThread().getName());
        itemSize++;
        notifyAll();
    }

    public synchronized void get() {
        if (itemSize > 0) {
            System.out.println("get by: " + Thread.currentThread().getName());
            itemSize--;
        }

        notifyAll();
    }
}
