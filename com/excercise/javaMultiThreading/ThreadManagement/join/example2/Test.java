package com.excercise.javaMultiThreading.ThreadManagement.join.example2;

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

public class Test {
    public static void main(String[] args) {
        // Creating two threads
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        // Start t1 execution
        t1.start();

        try {
            // t1.join(2000) means:
            // The main thread will wait for *at most* 2000 milliseconds (2 seconds)
            // for the t1 thread to finish.
            //
            // If t1 completes before 2 seconds, main resumes immediately after t1 ends.
            // If t1 is still running after 2 seconds, main resumes anyway.
            t1.join(2000);  // Join with a timeout of 2 seconds
        } catch (InterruptedException e) {
            // This block handles the case if the main thread is interrupted while waiting
            e.printStackTrace();
        }

        // This line runs after:
        // - t1 finishes within 2 seconds, or
        // - 2 seconds pass, whichever comes first.
        System.out.println("Main thread resumes execution.");
        t2.start();  // t2 starts after t1 is done or after 2 seconds
    }
}