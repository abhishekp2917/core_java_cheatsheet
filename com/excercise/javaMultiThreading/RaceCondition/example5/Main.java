package com.excercise.javaMultiThreading.RaceCondition.example5;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * A thread-safe counter using AtomicInteger.
 * AtomicInteger belongs to the java.util.concurrent.atomic package and provides
 * atomic operations for integers without using synchronization.
 */
class Counter {
    // AtomicInteger is a class that allows lock-free, thread-safe operations on integers.
    // It uses low-level CPU instructions like CAS (Compare-And-Swap) to ensure that
    // updates to the value are atomic — i.e., indivisible.
    private AtomicInteger count = new AtomicInteger(0);

    /**
     * Atomically increments the current value by 1.
     * The method incrementAndGet() ensures that the increment operation is thread-safe,
     * without requiring explicit locks or synchronized blocks.
     */
    public void increment() {
        count.incrementAndGet(); // Atomically: count = count + 1
    }

    /**
     * Atomically retrieves the current value.
     * Since get() is also atomic, it ensures visibility guarantees across threads.
     */
    public int getCount() {
        return count.get(); // Returns the current value atomically
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Create a shared Counter instance which will be used by multiple threads
        Counter counter = new Counter();

        // Thread t1: increments the counter 10000 times
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment(); // Safe even when accessed concurrently
            }
        });

        // Thread t2: also increments the counter 10000 times
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        });

        // Start both threads — they will run in parallel
        t1.start();
        t2.start();

        // Wait for both threads to complete before proceeding
        t1.join();
        t2.join();

        // Since AtomicInteger ensures atomic increments, the final count will always be 2000
        System.out.println("Final Count: " + counter.getCount());
    }
}
