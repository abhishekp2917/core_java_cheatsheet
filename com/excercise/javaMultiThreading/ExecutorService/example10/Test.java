import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {
        // Create a fixed-size thread pool with 2 threads
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Submit 5 tasks to the executor
        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            
            // Submit each task to be executed by one of the threads in the pool
            executor.submit(() -> {
                System.out.println("Task " + taskId + " started.");
                // Simulate some work for 5 seconds
                introduceDelay(6000); 
                System.out.println("Task " + taskId + " finished.");
            });
        }

        // Pause for 1 second to let some tasks start before calling shutdownNow
        introduceDelay(1000);

        // Forcefully shutdown the executor
        // shutdownNow() attempts to stop all currently executing tasks
        // and stops the acceptance of new tasks.
        List<Runnable> notStarted = executor.shutdownNow();

        // Print how many tasks were not started because of shutdownNow
        System.out.println("shutdownNow() called. Pending tasks: " + notStarted.size());

        // Note: Tasks that were already running (Task 1 and Task 2 in this case)
        // will be interrupted if they are executing at the time of shutdownNow().
    }

    private static void introduceDelay(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted while sleeping.");
        }
    }
}
