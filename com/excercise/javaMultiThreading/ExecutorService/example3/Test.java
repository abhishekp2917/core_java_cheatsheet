import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {
        // Creates a thread pool using Executors.newCachedThreadPool()
        // - This is an unbounded thread pool.
        // - It creates **new threads as needed** (if no idle thread is available).
        // - It **reuses previously constructed threads** when they are available.
        // - Threads that remain idle for **60 seconds** are terminated and removed from the pool.
        // - Best suited for applications that launch **many short-lived asynchronous tasks**.
        ExecutorService executor = Executors.newCachedThreadPool();

        // Submitting 5 tasks to the thread pool
        for (int i = 1; i <= 5; i++) {
            int taskId = i;

            // Submit each task
            executor.submit(() -> {
                System.out.println("Task " + taskId + " running on " + Thread.currentThread().getName());

                try {
                    Thread.sleep(2000); // Simulate some work for 2 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Task " + taskId + " completed");
            });
        }

        // Initiates a graceful shutdown:
        // - No new tasks will be accepted.
        // - Previously submitted tasks will continue to run.
        executor.shutdown();
    }
}
