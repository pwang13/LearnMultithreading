package displayhelper;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

public class ExecutorHost implements Host {
    private final Executor executor;
    private final Helper helper;

    public ExecutorHost(Executor executor, Helper helper) {
        this.helper = helper;
        this.executor = executor;
    }

    @Override
    public void request(String msg) {
        executor.execute(() -> {
            try {
                helper.handle(msg);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
