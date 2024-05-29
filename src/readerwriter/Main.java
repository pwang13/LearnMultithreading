package readerwriter;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {
    /**
     * 两种方式实现的读写锁
     * 1. 使用 synchronized + 读写判断实现针对写的互斥
     * 2. 使用 lock 包的 reentrantReadWriteLock
     * @param args
     */
    public static void main(String[] args) {
        ReadWriteLock readWriteLock = new ReadWriteLock();
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock(true);
        Data data = new Data(readWriteLock,reentrantReadWriteLock, 20);

        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new WriterThread(data, "abcdwdfsdfsef").start();
        new WriterThread(data, "rqeriyewrioywery").start();
        new ReaderThread(data).start();
    }
}
