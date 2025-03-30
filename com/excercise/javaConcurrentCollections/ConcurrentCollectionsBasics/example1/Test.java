package com.excercise.javaConcurrentCollections.ConcurrentCollectionsBasics.example1;

import java.util.ArrayList;
import java.util.Iterator;

public class Test {

    public static void main(String[] args) {
        // Creating an ArrayList with initial values
        // Note: ArrayList is NOT thread-safe, meaning concurrent modifications can cause issues.
        ArrayList<Integer> list = new ArrayList<>();
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
                list.add(6); // Structural modification of list (causes ConcurrentModificationException)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Starting the child thread
        childThread.start();

        // Main Thread: Iterates over the list
        try {
            // Creating an iterator for ArrayList
            // This iterator is "fail-fast" - it will detect structural modifications
            Iterator<Integer> iterator = list.iterator();
            
            while (iterator.hasNext()) {
                System.out.println("Main Thread: " + iterator.next());

                // Introducing a delay to ensure that the child thread modifies the list during iteration
                Thread.sleep(200); // This gives enough time for concurrent modification
            }
        } catch (Exception e) {
            // Catching and printing ConcurrentModificationException when detected
            System.out.println("Exception in Main Thread: " + e);
        }
    }
}
