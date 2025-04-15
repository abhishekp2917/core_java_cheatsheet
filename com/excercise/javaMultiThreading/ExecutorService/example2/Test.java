import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {
        // Create a thread pool with a fixed number of 2 threads.
        // - Executors.newFixedThreadPool(n) creates a pool with exactly 'n' threads.
        // - At any time, a maximum of 2 tasks will run concurrently.
        // - If more tasks are submitted, they are placed in an unbounded queue and wait for a thread to become available.
        // - Threads are reused — once a task is finished, the thread is returned to the pool and picks up the next task.
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Submit 4 tasks to the thread pool
        for (int i = 1; i <= 4; i++) {
            int taskId = i;

            // Submit each task as a Runnable lambda to the executor
            executor.submit(() -> {
                // Print the task number and the thread it is running on
                System.out.println("Task " + taskId + " is running on " + Thread.currentThread().getName());

                try {
                    // Simulate task duration of 2 seconds
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    // Handle interruption during sleep (if shutdownNow is called)
                    e.printStackTrace();
                }

                // Task completion message
                System.out.println("Task " + taskId + " completed");
            });
        }

        // No new tasks will be accepted after this point.
        // Already submitted tasks will be executed before shutdown completes.
        executor.shutdown(); // Initiates a graceful shutdown
    }
}