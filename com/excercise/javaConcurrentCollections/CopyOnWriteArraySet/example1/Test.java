package com.excercise.javaConcurrentCollections.CopyOnWriteArraySet.example1;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public class Test {
    public static void main(String[] args) {
        // Creating a CopyOnWriteArraySet
        CopyOnWriteArraySet<Integer> set = new CopyOnWriteArraySet<>();
        
        // Adding initial values
        set.add(1);
        set.add(2);
        set.add(3);
        
        // Child thread modifying the set
        Thread childThread = new Thread(() -> {
            try {
                Thread.sleep(100); // Ensuring main thread starts iteration first
                System.out.println("Child Thread: Adding elements to set...");
                set.add(3); // No ConcurrentModificationException
                set.add(4);
                set.add(null);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        
        childThread.start();

        // Main thread iterating over the set
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println("Main Thread: " + iterator.next());
            try {
                Thread.sleep(200); // Simulating delay to allow modification
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        // Waiting for child thread to finish
        try {
            childThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Printing the final state of the set
        System.out.println("Final Set: " + set);
    }
}
