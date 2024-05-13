package singlethread.deadlock;

public class Tool {
    private final String name;

    public Tool(String name) {
        this.name = name;
    }

    public Tool(Tool tool) {
        this.name = tool.name;
    }

    public void use() {
        System.out.println(Thread.currentThread().getName() + " get " + this.name);
    }
}
