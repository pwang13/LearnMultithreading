package singlethread.deadlock;

public class PairUserThread implements Runnable {
    private final String name;
    private final ToolPair toolPair;

    public PairUserThread(String name, ToolPair pair) {
        this.name = name;
        this.toolPair = new ToolPair(pair);
    }

    public void run() {
        synchronized (toolPair) {
            toolPair.use();
        }
    }
}
