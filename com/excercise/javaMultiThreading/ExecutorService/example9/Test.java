import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

public class Test {
    public static void main(String[] args) {
        // Step 1: Create an ExecutorService with a fixed thread pool of size 2.
        // This means only 2 threads will be able to run concurrently.
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Runnable runnableTask = () -> {
            // Step 2: Submit tasks to the executor.
            for (int i = 1; i <= 6; i++) {
                // Capture the task ID for each task submission.
                final int taskId = i; 

                try{
                    // Step 3: Submit a new task (Runnable) to the executor.
                    executor.submit(() -> {
                        System.out.println("Task " + taskId + " started.");
                        try {
                            // Simulate work by sleeping for 2 seconds (you can think of it as some I/O operation or processing).
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            // If the task is interrupted, it will print a message and stop.
                            System.out.println("Task " + taskId + " was interrupted.");
                        }
                        System.out.println("Task " + taskId + " finished.");
                    });
                }
                catch(RejectedExecutionException e){
                    // If task are rejected after shutdown, it will be caught here.
                    System.out.println("Error submitting task " + taskId);
                }

                // Introduce a delay of 1 second between task submissions.
                introduceDelay(1000); 
            }            
        };

        Thread taskThread = new Thread(runnableTask);
        // Start the thread that will submit tasks to the executor.
        taskThread.start(); 

        introduceDelay(3000);

        // Step 4: Initiates graceful shutdown of the executor.
        // Once shutdown is called:
        // - No new tasks will be accepted.
        // - The currently running tasks (if any) will be allowed to complete.
        // - The executor will eventually be in a terminated state once all tasks are finished.
        executor.shutdown();

        // Step 5: Print a message indicating that the shutdown process has been initiated.
        // At this point, the executor will stop accepting new tasks but will allow running tasks to finish.
        System.out.println("Executor shutdown called.");
    }

    private static void introduceDelay(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted while sleeping.");
        }
    }
}
