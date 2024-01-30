package Task1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class SolutionTask1 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        AtomicLong counter1 = new AtomicLong(0);
        AtomicLong counter2 = new AtomicLong(0);

        int threadCount = 100_000;

        for (int i = 0; i < threadCount; i++) {
            executorService.submit(() -> {
                counter1.incrementAndGet();
                counter2.incrementAndGet();
            });
        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Counter1: " + counter1.get());
        System.out.println("Counter2: " + counter2.get());
        executorService.shutdownNow();
    }
}
