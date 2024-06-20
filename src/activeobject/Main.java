package activeobject;

public class Main {
    public static void main(String[] args) {
        ActiveObject activeObject = ActiveObjectFactory.getInstance();
        new MakerThread("banana", activeObject).start();
        new MakerThread("apple", activeObject).start();
        new DisplayThread("chirs", activeObject).start();
    }
}
