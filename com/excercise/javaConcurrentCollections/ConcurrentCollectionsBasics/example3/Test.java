package com.excercise.javaConcurrentCollections.ConcurrentCollectionsBasics.example3;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class Test {

    public static void main(String[] args) {
        // Using CopyOnWriteArrayList instead of ArrayList
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();

        // Adding initial elements
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        // Child Thread: Modifies the list while the main thread is iterating
        Thread childThread = new Thread(() -> {
            try {
                Thread.sleep(100); // Ensuring main thread starts iteration first
                System.out.println("Child Thread: Modifying list...");
                list.add(6); // No exception occurs
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Starting the child thread
        childThread.start();

        // Main Thread: Iterates over the list
        try {
            Iterator<Integer> iterator = list.iterator();
            while (iterator.hasNext()) {
                System.out.println("Main Thread: " + iterator.next());
                Thread.sleep(200); // Simulating delay to allow modification
            }
        } catch (Exception e) {
            System.out.println("Exception in Main Thread: " + e);
        }

        // Ensuring child thread completes execution before program exits
        try {
            childThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Printing final list to verify changes
        System.out.println("Final List: " + list);
    }
}
