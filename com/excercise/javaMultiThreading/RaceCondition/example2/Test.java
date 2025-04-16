package com.excercise.javaMultiThreading.RaceCondition.example2;

// A simple Counter class that is thread-safe
class Counter {
    private int count = 0;

    /**
     * synchronized method ensures that only one thread at a time
     * can execute this method on the same Counter object.
     * 
     * It implicitly locks the current object (i.e., 'this') before entering the method,
     * and unlocks it when the method exits.
     * 
     * This prevents a race condition where two threads might read and write
     * the shared variable 'count' simultaneously, leading to incorrect results.
     */
    public synchronized void increment() {
        count++;  // read-modify-write operation made atomic via synchronization
    }

    /**
     * Not synchronized, but it's okay in this case since we're only reading a primitive value.
     * However, for high consistency requirements in concurrent systems, even getters may be synchronized
     * or declared with 'volatile'.
     */
    public int getCount() {
        return count;
    }
}

public class Test {
    public static void main(String[] args) {
        Counter counter = new Counter();

        // Thread 1 increments the counter 10000 times
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();  // Accessing synchronized method
            }
        });

        // Thread 2 increments the counter 10000 times
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();  // Accessing synchronized method
            }
        });

        // Start both threads
        t1.start();
        t2.start();

        // Main thread waits for t1 and t2 to complete execution
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /**
         * Expected final count is 20000 (10000 from each thread).
         * 
         * With synchronized keyword in place, race conditions are avoided,
         * and the final result should always be correct (i.e., 20000).
         * 
         * If 'increment()' were NOT synchronized, race conditions would occur,
         * and the result would often be less than 20000 due to lost updates.
         */
        System.out.println("Final Counter Value: " + counter.getCount());
    }
}
