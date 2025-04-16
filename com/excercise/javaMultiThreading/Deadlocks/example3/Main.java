package com.excercise.javaMultiThreading.Deadlocks.example3;

import java.util.concurrent.locks.ReentrantLock;

// Shared resource class protected by a ReentrantLock
class SharedResource {
    // Creating an unfair lock by default (non-fair ReentrantLock)
    ReentrantLock lock = new ReentrantLock(); // unfair means no guaranteed ordering of thread acquisition

    // Method to access the shared resource
    void accessResource() {
        // Attempt to acquire the lock
        lock.lock();
        try {
            // Critical section starts
            System.out.println(Thread.currentThread().getName() + " acquired the lock");

            // Simulate some work by sleeping for 1 second
            try { Thread.sleep(1000); } catch (InterruptedException e) {}
        } finally {
            // Always release the lock in a finally block to avoid deadlock
            lock.unlock();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        // High-Priority Thread: Keeps running in a tight loop trying to acquire the lock
        Thread highPriorityThread = new Thread(() -> {
            while (true) {
                resource.accessResource();
            }
        }, "High-Priority-Thread");

        // Low-Priority Thread: Also trying to access the same resource
        Thread lowPriorityThread = new Thread(() -> {
            while (true) {
                resource.accessResource();
            }
        }, "Low-Priority-Thread");

        // Set thread priorities (hint to the scheduler, but not guaranteed enforcement)
        highPriorityThread.setPriority(Thread.MAX_PRIORITY); // Priority = 10
        lowPriorityThread.setPriority(Thread.MIN_PRIORITY);  // Priority = 1

        highPriorityThread.start();
        lowPriorityThread.start();
    }
}

