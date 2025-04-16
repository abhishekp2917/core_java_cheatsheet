package com.excercise.javaMultiThreading.Locks.example1;

import java.util.concurrent.locks.ReentrantLock;

class MyTask {
    // Create a ReentrantLock object
    private final ReentrantLock lock = new ReentrantLock();

    // Method that needs to be thread-safe
    public void doWork() {
        // Acquire the lock before entering the critical section
        lock.lock();

        try {
            // Critical section (only one thread can run this at a time)
            System.out.println(Thread.currentThread().getName() + " is working");
            
            // Simulate some work
            try {
                Thread.sleep(5000); // Sleep for few second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " finished work");
        } finally {
            // Always release the lock to avoid deadlocks
            lock.unlock();
        }
    }
}

public class Test {
    public static void main(String[] args) {
        MyTask task = new MyTask();

        // Create two threads that will run the same task
        Thread t1 = new Thread(task::doWork, "Thread-1");
        Thread t2 = new Thread(task::doWork, "Thread-2");

        // Start the threads
        t1.start();
        t2.start();
    }
}
