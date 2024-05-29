package displayhelper;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class Main {
    public static void main(String[] args) {
        Helper helper = new Helper();
//        DefaultHost host = new DefaultHost(helper);
//        for (int i = 0; i < 100; i++) {
//            host.request(String.valueOf(i));
//        }

//        Executors.defaultThreadFactory();
//        FactoryHost factoryHost = new FactoryHost(new ThreadFactory() {
//            @Override
//            public Thread newThread(Runnable r) {
//                return new Thread(r);
//            }
//        }, helper);
//        for (int i = 0; i < 100; i++) {
//            factoryHost.request(String.valueOf(i));
//        }

//        Executors.newSingleThreadExecutor()
//        ExecutorHost executorHost = new ExecutorHost(new Executor() {
//            @Override
//            public void execute(Runnable command) {
//                new Thread(command).start();
//            }
//        }, helper);
//        for (int i = 0; i < 100; i++) {
//            executorHost.request(String.valueOf(i));
//        }

//        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        ExecutorServiceHost executorServiceHost = new ExecutorServiceHost(executorService, helper);
        try {
            for (int i = 0; i < 100; i++) {
                executorServiceHost.request(String.valueOf(i));
            }
        } finally {
            executorService.shutdown();
        }
    }
}
