// Represents a task with two synchronized methods
class Task {

    // This method will wait until it's notified
    public synchronized void doTask() {
        System.out.println("Task started...");
        try {
            /**
             * wait() causes the **current thread to release the lock** on 'this' object
             * and enter the WAITING state. It stays in this state until another thread
             * calls notify() or notifyAll() on the same object.
             * 
             * It must be called from within a synchronized context (inside a synchronized method/block)
             * because wait() needs to release the monitor (lock) and only works on an object’s monitor.
             * 
             * IMPORTANT: The thread does NOT proceed until it's re-acquired the lock after notification.
             */
            wait();  // Thread releases the monitor and waits to be notified
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // This line executes after the thread is notified and re-acquires the lock
        System.out.println("Task resumed after notification!");
    }

    // This method completes the task and notifies any waiting threads
    public synchronized void completeTask() {
        System.out.println("Task completed. Notifying...");

        /**
         * notify() wakes up a single thread that's waiting on this object's monitor.
         * The notified thread moves from WAITING to BLOCKED state, waiting to re-acquire the lock.
         * Once the lock becomes available, it resumes execution from where it called wait().
         */
        notify();  // Wakes up one thread waiting on this object's monitor
    }
}



public class Test {
    public static void main(String[] args) {
        Task task = new Task();

        // Thread that will perform the task and then wait
        Thread t1 = new Thread(task::doTask);

        // Thread that will notify t1 after completing something
        Thread t2 = new Thread(task::completeTask);

        // Start the waiting thread
        t1.start();

        try {
            Thread.sleep(5000);  // Simulate delay before notifying (e.g., some work being done)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Start the notifying thread
        t2.start();
    }
}
