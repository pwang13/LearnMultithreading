package displayhelper;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * 使用新线程来进行耗时操作
 * 5 种创建线程的方式
 * 1. new thread, new runnable
 * 2. thread factory 扩展线程创建的方式
 * 3. executor 扩展线程运行的方式
 * 4. executor service 可复用的线程运行逻辑
 * 5. scheduled executor service
 */
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
