package readerwriter;

import java.util.Arrays;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Data {
    private final char[] content;
    private final ReadWriteLock readWriteLock;
    private final int size;
    private int pointer;
    private final ReentrantReadWriteLock reentrantReadWriteLock;

    public Data(ReadWriteLock readWriteLock, ReentrantReadWriteLock reentrantReadWriteLock, int size) {
        this.readWriteLock = readWriteLock;
        this.reentrantReadWriteLock = reentrantReadWriteLock;
        this.size = size;
        content = new char[size];
        pointer = 0;
    }

    public char[] read() throws InterruptedException {
        readWriteLock.lockRead();
        reentrantReadWriteLock.readLock().lock();
        try {
            return Arrays.copyOf(content, size);
        } finally {
            readWriteLock.unlockRead();
            reentrantReadWriteLock.readLock().unlock();
        }
    }

    public void write(char c) throws InterruptedException {
//        readWriteLock.lockWrite();
        reentrantReadWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " writing " + c + " at " + pointer % size);
            content[pointer % size] = c;
            pointer++;

        } finally {
            readWriteLock.unlockWrite();
            reentrantReadWriteLock.writeLock().unlock();
        }
    }

}
