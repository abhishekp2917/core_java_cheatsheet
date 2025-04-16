package com.excercise.javaMultiThreading.Locks.example2;

import java.util.concurrent.locks.ReentrantReadWriteLock;

class SharedData {
    private int value = 0;

    // Create a read-write lock
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    // Separate locks for reading and writing
    private final ReentrantReadWriteLock.ReadLock readLock = rwLock.readLock();
    private final ReentrantReadWriteLock.WriteLock writeLock = rwLock.writeLock();

    // Method for reading data
    public void readData() {
        readLock.lock(); // Acquire read lock (multiple threads can hold this simultaneously if no writer holds the write lock)
        try {
            System.out.println(Thread.currentThread().getName() + " is reading value: " + value);
            Thread.sleep(1000); // Simulate read delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock.unlock(); // Release read lock
        }
    }

    // Method for writing data
    public void writeData(int newValue) {
        writeLock.lock(); // Acquire write lock (exclusive: no readers or other writers allowed)
        try {
            System.out.println(Thread.currentThread().getName() + " is writing value: " + newValue);
            Thread.sleep(3000); // Simulate write delay
            this.value = newValue;
            System.out.println(Thread.currentThread().getName() + " has written value: " + newValue);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock(); // Release write lock
        }
    }
}

public class Test {
    public static void main(String[] args) {
        SharedData data = new SharedData();

        // Create reader threads
        Runnable readTask = () -> {
            for (int i = 0; i < 3; i++) {
                data.readData();
            }
        };

        // Create writer threads
        Runnable writeTask = () -> {
            for (int i = 1; i <= 2; i++) {
                data.writeData(i * 10);
            }
        };

        // Starting multiple readers and writers
        Thread reader1 = new Thread(readTask, "Reader-1");
        Thread reader2 = new Thread(readTask, "Reader-2");
        Thread writer1 = new Thread(writeTask, "Writer-1");

        reader1.start();
        reader2.start();
        writer1.start();
    }
}
