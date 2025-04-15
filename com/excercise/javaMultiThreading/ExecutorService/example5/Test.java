import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        // Creates a ScheduledExecutorService with a pool of 2 threads.
        //
        // This is useful when you want to:
        // - Schedule tasks to run after a delay
        // - Schedule tasks to run periodically (at fixed rate or fixed delay)
        //
        // Unlike `newSingleThreadScheduledExecutor`, this allows **multiple scheduled tasks to run concurrently**
        // (up to the number of threads in the pool — 2 here).
        //
        // Internally backed by ScheduledThreadPoolExecutor.
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        // Define a task that prints the thread name and current time
        Runnable task = () -> {
            System.out.println("Running task on: " + Thread.currentThread().getName()
                    + " at " + System.currentTimeMillis());
        };

        // Schedules the task to run repeatedly with a **fixed delay** of 2 seconds
        // between the **end of one execution and the start of the next**.
        //
        // Parameters:
        // - Initial delay: 0 seconds (starts immediately)
        // - Delay between executions: 2 seconds after each task completes
        // - TimeUnit: SECONDS
        scheduler.scheduleWithFixedDelay(task, 0, 2, TimeUnit.SECONDS);

        // Optionally schedule another task to shut down the scheduler after 10 seconds
        //
        // This prevents the application from running indefinitely.
        // If not called, the application would continue running since the scheduler keeps threads alive.
        scheduler.schedule(() -> {
            System.out.println("Shutting down...");
            scheduler.shutdown();
        }, 10, TimeUnit.SECONDS);
    }
}
