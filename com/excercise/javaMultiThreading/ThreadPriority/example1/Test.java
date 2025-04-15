// Custom thread class extending Thread
class MyThread extends Thread {

    @Override
    public void run() {
        // This code will run when the thread starts
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " is running...");
        }
    }
}

public class Test {
    public static void main(String[] args) {
        // Create two threads
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        // Java threads have priority between 1 (MIN_PRIORITY) and 10 (MAX_PRIORITY)
        // Default priority is 5 (NORM_PRIORITY)

        // Priority is a hint to the thread scheduler about the importance of the thread
        // Higher-priority threads are more likely to be chosen to run before lower-priority ones
        // HOWEVER: Thread priority behavior is **platform-dependent**
        // It may not guarantee execution order especially in modern JVMs

        t1.setPriority(Thread.MIN_PRIORITY); // Priority = 1 (Lowest)
        t2.setPriority(Thread.MAX_PRIORITY); // Priority = 10 (Highest)

        // Start both threads
        t1.start();  // Starts execution of t1 (low priority)
        t2.start();  // Starts execution of t2 (high priority)

        // - Setting thread priority does not guarantee order of execution.
        // - On many systems, thread scheduling is managed by the OS and JVM may ignore priorities.
        // - Use priorities only when you truly understand the system-level behavior or are on real-time systems.

        // Do not rely heavily on thread priority for program logic.
        // Use proper synchronization and design for consistent results.
    }
}
