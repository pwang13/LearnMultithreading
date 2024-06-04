package future;

public class Channel {

    public FutureData submit(RealData realData) {
        FutureData futureData = new FutureData(realData);
        System.out.println(Thread.currentThread().getName() + " submit");
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " begin");
                futureData.submit();
                System.out.println(Thread.currentThread().getName() + " end");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        System.out.println(Thread.currentThread().getName() + " submitted");
        return futureData;
    }

    public String get(FutureData futureData) throws InterruptedException {
        return futureData.fetch();
    }
}
