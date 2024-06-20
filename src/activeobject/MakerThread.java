package activeobject;

public class MakerThread extends Thread {
    public final String name;
    public final ActiveObject activeObject;

    public MakerThread(String name, ActiveObject activeObject) {
        this.name = name;
        this.activeObject = activeObject;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i < 10; i++) {
                Result<String> res = activeObject.makeString(i, name.charAt(0));
                // other operations
                String s = res.getResult();
                System.out.println("made " + s);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
