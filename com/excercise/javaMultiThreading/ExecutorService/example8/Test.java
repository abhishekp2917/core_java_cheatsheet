import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) {
        // Create a Runnable task that simply prints a message.
        // A Runnable does not return a result, it only performs a task.
        Runnable runnable = () -> {   
            try {
                System.out.println("Running a task...");
                // Simulate some long-running computation
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // Handle the InterruptedException in case the thread is interrupted during sleep
                Thread.currentThread().interrupt();
                System.out.println("Task was interrupted.");
            }
        };

        // Wrap the Runnable task in a FutureTask with a predefined result ("DONE").
        // FutureTask is a class that implements both `Runnable` and `Future` interface.
        // The `Runnable` will execute the task, and the `Future` will allow us to retrieve the result once the task completes.
        // The predefined result ("DONE") will be returned when the task completes successfully.
        FutureTask<String> futureTask = new FutureTask<>(runnable, "DONE");

        // Create a new thread to run the FutureTask.
        // A FutureTask is a `Runnable` so we can pass it to a `Thread` constructor to run the task.
        Thread thread = new Thread(futureTask);
        thread.start();  // Start the thread which will run the task

        try {
            // Call `futureTask.get()` to block and wait for the task to finish and get its result.
            // The `get()` method is blocking and will wait until the task is complete.
            // Once the task completes, the result ("DONE") will be returned from the FutureTask.
            String result = futureTask.get();  // This blocks until the task finishes.
            System.out.println("FutureTask Result: " + result);  // Print the result from the FutureTask
        } catch (Exception e) {
            // Handle any exceptions that might occur during task execution or getting the result.
            e.printStackTrace();
        }
    }
}
