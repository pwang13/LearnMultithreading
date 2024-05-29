package displayhelper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

public class ExecutorServiceHost implements Host {
    private final ExecutorService executorService;
    private final Helper helper;

    public ExecutorServiceHost(ExecutorService executorService, Helper helper) {
        this.helper = helper;
        this.executorService = executorService;
    }

    @Override
    public void request(String msg) {
        executorService.execute(() -> {
            try {
                helper.handle(msg);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
