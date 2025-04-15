package com.excercise.javaMultiThreading.ThreadManagement.yield.example1;


// Custom thread class extending Thread
class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            // Print current thread name and counter value
            System.out.println(Thread.currentThread().getName() + " : " + i);

            // Hint to the thread scheduler to pause current thread and give a chance to others
            Thread.yield();

            /**             
             *
             * - The current thread goes back to the **ready/runnable state**, not blocked or sleeping.
             * - It's just a **hint** to the OS — the thread might continue execution if no other thread is eligible.
             *
             * Important Notes:
             * - It does NOT release any locks.
             * - It does NOT guarantee that other threads will run.
             *
             */
        }
    }
}

// Main class to run the thread example
public class Test {
    public static void main(String[] args) {
        // Create two threads
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        // Start both threads
        t1.start();
        t2.start();
    }
}
