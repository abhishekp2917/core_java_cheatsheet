import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {
        // Creates a thread pool with only **one thread** (single-threaded executor)
        // Tasks submitted to this executor will be executed **sequentially**, in the order they are received.
        // Even if multiple tasks are submitted, they will not run in parallel — they will be queued and executed one-by-one.
        //
        // Internally, it uses an unbounded queue (LinkedBlockingQueue) and a single worker thread.
        // If the thread dies unexpectedly, a new thread is created to replace it.
        //
        // Suitable when:
        // - You want to serialize task execution.
        // - You want to offload work from the main thread but still ensure no concurrent execution.
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // Submitting 3 tasks to the single-thread executor
        for (int i = 1; i <= 3; i++) {
            int taskId = i;

            // Each task prints start and completion messages with a 1-second delay
            executor.submit(() -> {
                System.out.println("Task " + taskId + " is running on " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000); // Simulate work (blocking operation)
                } catch (InterruptedException e) {
                    e.printStackTrace(); // This will print stack trace if task is interrupted
                }
                System.out.println("Task " + taskId + " completed");
            });
        }

        // Initiates an orderly shutdown: no new tasks accepted,
        // but previously submitted tasks will be executed
        executor.shutdown();
    }
}
