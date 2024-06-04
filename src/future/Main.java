package future;

public class Main {
    /**
     * future 模式
     * 使用 future data 来保护 数据状态是否可用
     * 使用 channel 的 thread per message 模式开启异步线程
     *
     * 使用 concurrent 包种的 future 或者 future task 可以达到相同的效果
     * @param args
     */
    public static void main(String[] args) {
        Channel channel = new Channel();
        ClientThread clientThread = new ClientThread(channel);
        clientThread.start();
    }
}
