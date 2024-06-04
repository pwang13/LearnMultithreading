package future;

public class FutureData {
    private final RealData realData;
    private boolean isReady = false;

    public FutureData(RealData realData) {
        this.realData = realData;
    }

    public synchronized void submit() throws InterruptedException {
        realData.fetchContent();
        isReady = true;
        notifyAll();
    }

    public synchronized String fetch() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " before wait");
        while (!isReady) {
            wait();
        }
        System.out.println(Thread.currentThread().getName() + " finished waiting ");

        return realData.getResult();
    }
}
