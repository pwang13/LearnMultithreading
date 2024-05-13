package singlethread.deadlock;

public class ToolPair {
    private final Tool fork, knife;

    // init immutable
    public ToolPair(Tool fork, Tool knife) {
        this.fork = new Tool(fork);
        this.knife = new Tool(knife);
    }

    public ToolPair(ToolPair toolPair) {
        // can use prototype to deep clone
        this.fork = new Tool(toolPair.fork);
        this.knife = new Tool(toolPair.knife);
    }

    public void use() {
        fork.use();
        knife.use();
    }
}
