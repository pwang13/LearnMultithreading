package displayhelper;

import java.util.concurrent.ThreadFactory;

public class FactoryHost  implements Host {
    private final ThreadFactory factory;
    private final Helper helper;

    public FactoryHost(ThreadFactory threadFactory, Helper helper) {
        this.factory = threadFactory;
        this.helper = helper;
    }

    @Override
    public void request(String msg) {
        factory.newThread(() -> {
            try {
                helper.handle(msg);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
