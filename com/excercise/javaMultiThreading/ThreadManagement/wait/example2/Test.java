package com.excercise.javaMultiThreading.ThreadManagement.wait.example2;

// Represents a task with a synchronized method
class Task {

    // Synchronized method so that calling thread must acquire the monitor lock on 'this' object
    public synchronized void doTask() {
        System.out.println("Task started...");

        try {
            // wait(3000) causes the current thread to:
            // - Release the monitor lock on 'this' object
            // - Go into a waiting state for up to 3000 milliseconds (3 seconds)
            // - It will resume earlier if it's notified by another thread using notify()/notifyAll()
            // - Once the time expires or it's notified, it will attempt to re-acquire the lock before proceeding
            wait(3000);
        } catch (InterruptedException e) {
            e.printStackTrace(); // If thread is interrupted while waiting
        }

        // This line executes after:
        // 1. The wait time (3 seconds) has elapsed, or
        // 2. The thread was notified (and re-acquired the lock)
        System.out.println("Task resumed after waiting!");
    }
}

public class Test {
    public static void main(String[] args) {
        Task task = new Task();

        // Create a thread that will execute the doTask() method
        Thread t1 = new Thread(task::doTask);

        // Start the thread; it will enter the synchronized method and call wait(3000)
        t1.start();
    }
}
