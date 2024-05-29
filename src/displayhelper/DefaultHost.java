package displayhelper;

public class DefaultHost implements Host {
    private final Helper helper;

    public DefaultHost(Helper helper) {
        this.helper = helper;
    }

    public void request(String msg) {
        Thread executor = new Thread(() -> {
            try {
                helper.handle(msg);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        executor.start();

//        helper.anotherHandle(msg);
    }

}
