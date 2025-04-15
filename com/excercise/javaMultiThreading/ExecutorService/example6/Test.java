import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) {
        // Create an ExecutorService (a single-threaded thread pool)
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // Define a Callable task (returns a result and can throw an exception)
        Callable<String> callable = () -> {
            // Simulate a long-running task (e.g., database call, file processing, etc.)
            Thread.sleep(5000); 
            return "Hello from Future!";
        };

        // Submit the Callable task to the executor
        // It returns a Future object representing the pending result of the task
        Future<String> future = executor.submit(callable);

        System.out.println("Task submitted...");

        try {
            // ===== FUTURE DETAILS =====
            // The `Future` interface provides methods to:
            // 1. get(): Block and wait for the result.
            // 2. cancel(): Cancel the task if not already completed.
            // 3. isDone(): Check if the task is completed.
            // 4. isCancelled(): Check if the task was cancelled.

            // Here, we're calling get(), which blocks until the Callable finishes
            String result = future.get();  // Blocks until the result is available

            // Once the task is done, the result is returned
            System.out.println("Result: " + result);

        } catch (InterruptedException | ExecutionException e) {
            // InterruptedException: if the current thread was interrupted while waiting
            // ExecutionException: if the computation threw an exception
            e.printStackTrace();
        } finally {
            // Always shut down the executor to free resources
            executor.shutdown();
        }
    }
}
