package com.excercise.javaConcurrentCollections.ConcurrentCollectionsBasics.example2;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        // Creating a synchronized version of ArrayList using Collections.synchronizedList
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());

        // Adding initial elements to the list
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
                list.add(6); // Modification allowed without exception
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Starting the child thread
        childThread.start();

        // Main Thread: Iterates over the list in a synchronized block
        try {
            synchronized (list) { // Explicit synchronization needed during iteration
                Iterator<Integer> iterator = list.iterator();
                while (iterator.hasNext()) {
                    System.out.println("Main Thread: " + iterator.next());
                    Thread.sleep(200); // Simulating delay to observe performance impact
                }
            }
        } catch (Exception e) {
            System.out.println("Exception in Main Thread: " + e);
        }
    }
}
