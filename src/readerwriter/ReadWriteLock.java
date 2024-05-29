package readerwriter;

public class ReadWriteLock {
//    private final Object readLock, writeLock;

    private boolean isReading, isWriting;
    private int countReading;
    private boolean writeFirst;
    private int countWriting;

    public ReadWriteLock() {
        isReading = false;
        isWriting = false;
        countReading = 0;
        writeFirst = false;
        countWriting = 0;
    }

    public synchronized void lockRead() throws InterruptedException {
        while (isWriting || (writeFirst && countWriting != 0)) {
            System.out.println(Thread.currentThread().getName() + " waiting");
            wait();
        }
        isReading = true;
        countReading++;
    }

    public synchronized void unlockRead() {
        countReading--;
        if (countReading == 0) {
            isReading = false;
            writeFirst = true;
        }
        notifyAll();
    }

    public synchronized void lockWrite() throws InterruptedException {
        if (isReading || isWriting) {
            countWriting++;
        }
        while (isReading || isWriting) {
            System.out.println(Thread.currentThread().getName() + " waiting");
            wait();
        }
        isWriting = true;
        writeFirst = false;
    }

    public synchronized void unlockWrite() {
        isWriting = false;
        countWriting--;
        notifyAll();
    }
}
