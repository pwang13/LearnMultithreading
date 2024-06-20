package activeobject;

public class FutureResult<T> extends Result<T> {
    private T result;
    private boolean isReady = false;

    public synchronized void setResult(T t) {
        result = t;
        isReady = true;
        notifyAll();
    }

    public synchronized T getResult() {
        while (!isReady) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }
}
