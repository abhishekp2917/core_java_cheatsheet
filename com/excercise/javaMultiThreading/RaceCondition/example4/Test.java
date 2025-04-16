package com.excercise.javaMultiThreading.RaceCondition.example4;

// This class simulates a shared resource accessed by multiple threads. 
class SharedResource {

    // A shared static variable - common across all instances of this class.
    private static int count = 0;

    /**
     * Static synchronized method.
     * ---------------------------------------
     * - This method acquires a lock on the Class object: SharedResource.class.
     * - Only one thread can execute ANY static synchronized method of this class at a time,
     *   regardless of which thread or how many objects exist.
     * - Ensures mutual exclusion at the class level.
     */
    public static synchronized void increment() {
        try {
            // Simulate delay to expose thread contention clearly
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Critical section: shared mutable state update
        count++;

        // Display which thread performed the increment
        System.out.println(Thread.currentThread().getName() + " incremented count to: " + count);
    }

    /**
     * Simple static method to read the current value of count.
     * Not synchronized as it's just reading.
     */
    public static int getCount() {
        return count;
    }
}


// Entry point of the program to test class-level locking via static synchronized method
public class Test {
    public static void main(String[] args) {

        // Creating three threads that all try to call SharedResource.increment()
        // Since increment() is static and synchronized, they will be serialized (executed one at a time)
        Thread t1 = new Thread(() -> SharedResource.increment(), "Thread-1");
        Thread t2 = new Thread(() -> SharedResource.increment(), "Thread-2");
        Thread t3 = new Thread(() -> SharedResource.increment(), "Thread-3");

        // Start the threads. They will compete for the lock on SharedResource.class
        t1.start();
        t2.start();
        t3.start();
    }
}
