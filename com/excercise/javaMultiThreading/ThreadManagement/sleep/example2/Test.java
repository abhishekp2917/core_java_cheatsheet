package com.excercise.javaMultiThreading.ThreadManagement.sleep.example2;

// This class defines a task that will sleep for 5 seconds and handles interruption
class Task implements Runnable {
    public void run() {
        try {
            System.out.println("Thread sleeping...");

            // This causes the current thread (worker thread) to sleep for 5 seconds (5000 ms)
            // During this time, it is in a TIMED_WAITING state and can be interrupted
            Thread.sleep(5000);

            // If not interrupted, this line will execute after 5 seconds
            System.out.println("Thread woke up!");
        } catch (InterruptedException e) {
            // If the thread is interrupted while sleeping, it will throw InterruptedException
            // This block handles that case
            System.out.println("Thread was interrupted!");
        }
    }
}

public class Test {
    public static void main(String[] args) {
        // Create a new thread that runs the Task
        Thread t = new Thread(new Task());
        t.start();  // Start the new thread, which enters the run() method

        try {
            // Main thread sleeps for 2 seconds (2000 ms)
            // During this time, the other thread is already sleeping
            Thread.sleep(2000);

            // After 2 seconds, main thread interrupts the sleeping thread 't'
            // This causes an InterruptedException to be thrown inside the sleeping thread
            t.interrupt();
        } catch (InterruptedException e) {
            // If main thread itself is interrupted during sleep, it will come here
            e.printStackTrace();
        }
    }
}
