package activeobject;

public class DisplayThread extends Thread {
    private final ActiveObject activeObject;
    private final String name;

    public DisplayThread(String name, ActiveObject activeObject) {
        this.activeObject = activeObject;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            while (true) {
                activeObject.displayString(name);
                Thread.sleep(10);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
