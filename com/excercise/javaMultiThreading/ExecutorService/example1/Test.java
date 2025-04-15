import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {
        // ✅ Create an ExecutorService using a fixed thread pool with 2 threads
        // This means at most 2 tasks will run concurrently
        ExecutorService service = Executors.newFixedThreadPool(2);

        // ✅ Create Runnable tasks (these define the units of work to be executed)
        Runnable task1 = () -> System.out.println("Task 1 executed by " + Thread.currentThread().getName());
        Runnable task2 = () -> System.out.println("Task 2 executed by " + Thread.currentThread().getName());
        Runnable task3 = () -> System.out.println("Task 3 executed by " + Thread.currentThread().getName());

        // ✅ Submit tasks to the ExecutorService for asynchronous execution
        // Tasks will be scheduled based on thread availability
        service.submit(task1);  // Task 1 is picked by one thread
        service.submit(task2);  // Task 2 is picked by second thread
        service.submit(task3);  // Task 3 waits until one of the two threads becomes free

        // ✅ Initiate a graceful shutdown
        // No new tasks will be accepted. Already submitted tasks will complete execution.
        service.shutdown();
    }
}
