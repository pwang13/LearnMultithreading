package thread;

public class SynchronizedBank {
    private int deposit;

    public synchronized void save(int amount) {
        deposit += amount;
    }

    public synchronized void collect(int amount) {
        if (deposit < amount) {
            throw new RuntimeException("not enough!");
        }
        deposit -= amount;
    }
}
