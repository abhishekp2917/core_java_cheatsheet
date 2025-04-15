package com.excercise.javaMultiThreading.ThreadManagement.notify.example2;

class Task {
    // This method makes each thread wait until it's notified
    public synchronized void doTask(int id) {
        System.out.println("Task " + id + " started...");

        try {
            // The thread releases the lock and enters WAITING state
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Executes only after this thread is notified and reacquires the lock
        System.out.println("Task " + id + " resumed after notification!");
    }

    // This method notifies all waiting threads to wake up
    public synchronized void completeTask() {
        System.out.println("All tasks completed. Notifying all...");

        // notifyAll() wakes up ALL threads waiting on this object's monitor.
        // Each of them will try to reacquire the lock and continue execution one by one.
        notifyAll();
    }
}

public class Test {
    public static void main(String[] args) {
        Task task = new Task();

        // Create multiple threads that call doTask()
        Thread t1 = new Thread(() -> task.doTask(1));
        Thread t2 = new Thread(() -> task.doTask(2));
        Thread t3 = new Thread(() -> task.doTask(3));

        // Start all waiting threads
        t1.start();
        t2.start();
        t3.start();

        try {
            Thread.sleep(3000); // Simulate delay before notifying
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // This thread will notify all waiting threads
        Thread notifier = new Thread(task::completeTask);
        notifier.start();
    }
}
