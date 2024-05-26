package queue;

public class Main {
    public static void main(String[] args) {
        RequestQueue queue = new RequestQueue(30L);
        Sender sender = new Sender(queue);
        Receiver receiver = new Receiver(queue);

        sender.start();
        receiver.start();
    }
}
