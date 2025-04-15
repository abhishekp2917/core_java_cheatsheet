package com.excercise.javaMultiThreading.ThreadManagement.interrupt.example2;

// Custom thread class extending Thread
class MyThread extends Thread {

    // Override run method which defines the thread's task
    public void run() {
        // Looping from 1 to 5
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread is running: " + i);

            // Check if the thread has been interrupted
            if (Thread.interrupted()) {
                // If interrupted, print message and stop further execution
                System.out.println("Thread is interrupted, stopping execution.");
                return;
            }

            // Optional: Sleep to simulate time-consuming work (not mandatory here)
            try {
                Thread.sleep(10);  // this allows time to check for interruption
            } catch (InterruptedException e) {
                // If sleep is interrupted, this block is triggered
                System.out.println("Thread interrupted during sleep, stopping execution.");
                return;
            }
        }
    }
}

// Main class to test thread interruption
public class Main {
    public static void main(String[] args) {
        // Create a new thread
        MyThread t1 = new MyThread();
        
        // Start the thread — this calls the run() method in a separate thread
        t1.start();

        try {
            // Main thread sleeps for a short time to allow t1 to start running
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Interrupt the thread t1
        // This sets the "interrupted" status of the thread to true
        // If t1 is sleeping, it will throw InterruptedException
        // If t1 is running, it must check interrupted status using Thread.interrupted()
        t1.interrupt();
    }
}
