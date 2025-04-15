// Custom thread class extending Thread
class MyThread extends Thread {

    @Override
    public void run() {
        // Each thread prints a count from 1 to 3 with 1-second delay
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName() + " - Count: " + i);
            try {
                Thread.sleep(1000);  // Simulates time-consuming task
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Main class with main thread execution
public class Test {

    public static void main(String[] args) {

        // Creating two threads
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        // Start t1 execution
        t1.start();

        try {
            /**
             * t1.join() means:
             * - The current thread (Main thread) will wait for t1 to finish execution.
             * - So, t2 will not be started until t1 has completed.
             * 
             * This ensures sequential execution: t1 -> then t2
             *
             * join() is useful when:
             * - You want one thread to wait for another to complete.
             * - It is commonly used when thread results are needed before proceeding.
             */
            t1.join();  // Main thread waits until t1 completes

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // t2 starts only after t1 is completely done
        t2.start();
    }
}
