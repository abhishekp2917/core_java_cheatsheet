package com.excercise.javaMultiThreading.ThreadManagement.interrupt.example1;

// Custom thread class extending Thread
class MyThread extends Thread {
    public void run() {
        try {
            System.out.println("Thread is going to sleep...");

            // The thread goes to sleep for 5 seconds
            Thread.sleep(5000);

            // If the sleep completes without interruption
            System.out.println("Thread woke up normally.");
        } catch (InterruptedException e) {
            // If the thread is interrupted while sleeping,
            // InterruptedException is thrown and caught here
            System.out.println("Thread was interrupted while sleeping!");
        }
    }
}

public class Test {
    public static void main(String[] args) {
        // Creating and starting a new thread
        MyThread t1 = new MyThread();
        t1.start(); // This will invoke the run() method of MyThread

        try {
            // Main thread sleeps for 2 seconds before interrupting t1
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // This is where interrupt() is used
        // It sets the "interrupted" status of t1 to true.
        // If t1 is currently sleeping, waiting, or blocked, it throws InterruptedException immediately.
        // Otherwise, the interrupt flag is just set and can be checked using Thread.interrupted() or t1.isInterrupted()
        t1.interrupt();
    }
}
