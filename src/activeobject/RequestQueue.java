package activeobject;

public class RequestQueue {
    private MethodRequest[] methodRequests;
    private int head, tail, count;
    private final int capacity;

    public RequestQueue(int capacity) {
        methodRequests = new MethodRequest[capacity];
        head = 0;
        tail = 0;
        this.capacity = capacity;
    }

    public synchronized void putRequest(MethodRequest methodRequest) {
        while (count == capacity) {
            System.out.println("reach capacity wait");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        methodRequests[tail] = methodRequest;
        tail = (tail + 1) % capacity;
        count++;
        notifyAll();
    }

    public synchronized MethodRequest getRequest() {
        while (count == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        MethodRequest request = methodRequests[head];
        head = (head + 1) % capacity;
        count--;
        return request;
    }
}
