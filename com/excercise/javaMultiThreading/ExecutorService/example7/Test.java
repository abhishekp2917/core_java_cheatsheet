import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) {
        // Step 1: Create a Callable task
        // Callable is like Runnable, but it can return a result and throw a checked exception
        Callable<String> callable = () -> {
            // Simulate some long-running computation
            Thread.sleep(3000);
            return "Result from Callable";
        };

        // Step 2: Wrap the Callable in a FutureTask
        // FutureTask is both Runnable and Future
        // - As Runnable: It can be executed by a Thread or ExecutorService
        // - As Future: It allows us to retrieve the result of the computation
        FutureTask<String> futureTask = new FutureTask<>(callable);

        // Step 3: Run the FutureTask using a Thread (alternative: submit to ExecutorService)
        Thread thread = new Thread(futureTask); // start a new thread with this task
        thread.start(); // internally calls futureTask.run(), which executes the Callable

        try {
            System.out.println("Doing other work...");

            // Step 4: Get the result from FutureTask (this call blocks until the task completes)
            // - If task is not finished, get() blocks
            // - If task completed, get() returns the result
            String result = futureTask.get();

            // Step 5: Print the result
            System.out.println("FutureTask Result: " + result);
        } catch (Exception e) {
            // Handles InterruptedException and ExecutionException
            e.printStackTrace();
        }
    }
}
