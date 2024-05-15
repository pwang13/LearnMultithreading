package autosave;

public class Data {
    private String content;
    private boolean saved;

    public Data() {}

    public synchronized void save() throws InterruptedException {
        if (!saved) {
            System.out.println(Thread.currentThread().getName() + " save " + content);
            Thread.sleep(100);
            saved = true;
        }
    }

    public synchronized void change(String content) {
        this.content = content;
        saved = false;
    }
}
