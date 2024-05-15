package queue;

public class Main {
    public static void main(String[] args) {
        RequestQueue queue = new RequestQueue();
        Sender sender = new Sender(queue);
        Receiver receiver = new Receiver(queue);

        sender.start();
        receiver.start();
    }
}
