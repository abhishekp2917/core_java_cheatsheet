package com.excercise.javaMultiThreading.Deadlocks.example1;

/*
============================== DEADLOCK EXPLANATION ==============================

WHEN DEADLOCK WILL HAPPEN:

1. Thread-1 starts and locks resourceA.
2. Thread-2 starts and locks resourceB.
3. Both threads then sleep for 1 second.
4. After sleep:
   - Thread-1 tries to lock resourceB → but it's already locked by Thread-2.
   - Thread-2 tries to lock resourceA → but it's already locked by Thread-1.
5. Now both threads are waiting for each other to release the lock → DEADLOCK occurs.
   - This is a classic case of **circular wait**.
   - Neither thread can proceed, and both are permanently blocked.

WHEN DEADLOCK WILL NOT HAPPEN:

- If Thread-1 finishes methodA (locks both resources) before Thread-2 starts.
- If Thread-2 finishes methodB (locks both resources) before Thread-1 starts.
- If the sleep duration or scheduling happens in such a way that one thread finishes both locks before the other enters its method.
*/


// This class simulates two resources trying to access each other in reverse order,
// which can cause a DEADLOCK situation.
class Resource {

    void methodA() {
        // Thread-1 will acquire lock on resourceA first (this refers to resourceA)
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " locked Resource-A");

            // Adding sleep to simulate processing time and increase the chance of deadlock
            try { Thread.sleep(1000); } catch (InterruptedException e) {}

            // Now Thread-1 tries to acquire lock on resourceB
            // If resourceB is already locked by Thread-2, this thread will wait here
            synchronized (Test.resourceB) {
                System.out.println(Thread.currentThread().getName() + " locked Resource-B");
            }
        }
    }

    void methodB() {
        // Thread-2 will acquire lock on resourceB first (this refers to resourceB)
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " locked Resource-B");

            // Adding sleep to simulate processing time and increase the chance of deadlock
            try { Thread.sleep(1000); } catch (InterruptedException e) {}

            // Now Thread-2 tries to acquire lock on resourceA
            // If resourceA is already locked by Thread-1, this thread will wait here
            synchronized (Test.resourceA) {
                System.out.println(Thread.currentThread().getName() + " locked Resource-A");
            }
        }
    }
}

public class Test {
    static Resource resourceA = new Resource();
    static Resource resourceB = new Resource();

    public static void main(String[] args) {
        // Thread-1 tries to lock resourceA first, then resourceB
        Thread t1 = new Thread(() -> resourceA.methodA(), "Thread-1");

        // Thread-2 tries to lock resourceB first, then resourceA
        Thread t2 = new Thread(() -> resourceB.methodB(), "Thread-2");

        t1.start();
        t2.start();
    }
}

