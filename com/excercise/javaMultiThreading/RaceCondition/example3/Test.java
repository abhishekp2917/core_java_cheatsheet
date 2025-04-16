package com.excercise.javaMultiThreading.RaceCondition.example3;

// This class defines two methods:
// 1. An unsynchronized method that any thread can enter without locking.
// 2. A synchronized block to demonstrate mutual exclusion.
class MyTask {

    // This method is not synchronized, so any thread can execute it at any time,
    // even if other threads are inside synchronized blocks of the same object.
    public void unsynchronizedMethod() {
        System.out.println(Thread.currentThread().getName() + " is in unsynchronized method.");
    }

    // This method contains a synchronized block on the current object (this).
    public void doSynchronizedWork() {
        // Only one thread can enter this block at a time for the same object instance.
        // The lock (monitor) is acquired on 'this' (i.e., the current instance of MyTask).
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " entered synchronized block.");

            try {
                // Simulate some long-running task while holding the lock.
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // Handle interruption (e.g., in shutdownNow() scenarios)
            }

            System.out.println(Thread.currentThread().getName() + " exiting synchronized block.");
        }
        // Once the block finishes, the lock is released and another waiting thread can enter.
    }
}


public class Test {
    public static void main(String[] args) {
        // All threads share the same instance of MyTask, so they compete for the same lock.
        MyTask task = new MyTask();

        // Thread-1 tries to enter the synchronized block.
        Thread t1 = new Thread(() -> task.doSynchronizedWork(), "Thread-1");

        // Thread-2 also tries to enter the synchronized block and must wait if Thread-1/Thread-3 is inside.
        Thread t2 = new Thread(() -> task.doSynchronizedWork(), "Thread-2");

        // Thread-3 also tries to enter the synchronized block and must wait if Thread-1/Thread-2 is inside.
        Thread t3 = new Thread(() -> task.doSynchronizedWork(), "Thread-3");

        // Thread-4 calls an unsynchronized method, which doesn't require any lock,
        // so it can execute at any time, even while the synchronized block is occupied.
        Thread t4 = new Thread(() -> task.unsynchronizedMethod(), "Thread-4");

        // Start all threads. The execution order depends on the JVM thread scheduler.
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
