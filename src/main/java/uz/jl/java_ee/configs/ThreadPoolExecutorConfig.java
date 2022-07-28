package uz.jl.java_ee.configs;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolExecutorConfig {

    private static final ExecutorService executorService =
            Executors.newFixedThreadPool(10);

    public static void run() {
        executorService.submit(() -> System.out.println("::::::::::TREAD POOL STARTED::::::::::"));
    }

    public static void execute(Runnable runnable) {
        executorService.submit(runnable);
    }

    public static <T> Future<T> execute(Callable<T> callable) {
        return executorService.submit(callable);
    }
}
