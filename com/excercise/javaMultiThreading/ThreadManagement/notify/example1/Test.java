package com.excercise.javaMultiThreading.ThreadManagement.notify.example1;

// A shared task class with synchronized methods
class Task {
    
    // This method makes the thread wait until it's notified
    public synchronized void doTask() {
        System.out.println("Task started...");

        try {
            // The current thread releases the monitor (lock) of this object
            // and enters the WAITING state.
            // It waits until some other thread calls notify() or notifyAll() on this object.
            wait(); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // This line will execute only after the thread is notified
        // and reacquires the object's monitor (lock).
        System.out.println("Task resumed after notification!");
    }

    // This method notifies the waiting thread to wake up
    public synchronized void completeTask() {
        System.out.println("Task completed. Notifying...");

        // notify() wakes up ONE thread that's waiting on this object's monitor.
        // If multiple threads are waiting, one of them is chosen arbitrarily.
        // The thread will not resume immediately — it will wait until it can reacquire the lock.
        notify(); 
    }
}

public class Test {
    public static void main(String[] args) {
        Task task = new Task(); // Shared object

        // Thread that performs the main task and waits
        Thread t1 = new Thread(task::doTask);

        // Thread that will notify t1 to resume
        Thread t2 = new Thread(task::completeTask);

        t1.start(); // Starts and waits inside doTask()

        try {
            Thread.sleep(3000);  // Simulate some delay before notifying
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2.start(); // Notifies t1 to continue
    }
}
