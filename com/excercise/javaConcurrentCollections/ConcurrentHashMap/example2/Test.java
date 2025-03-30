package com.excercise.javaConcurrentCollections.ConcurrentHashMap.example2;

import java.util.concurrent.ConcurrentHashMap;

public class Test {
    public static void main(String[] args) {
        // Creating a ConcurrentHashMap
        // ConcurrentHashMap allows safe concurrent access in multi-threaded environments.
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();

        // Adding initial values to the map
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Cherry");

        // Thread 1: Tries to remove a key-value pair from the map
        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1: Trying remove...");

            // The remove(K, V) method removes the key-value pair ONLY if both the key and value match.
            boolean removed = map.remove(3, "Apple"); // Will NOT remove because key 3 has value "Cherry"
            
            // The return value indicates whether the removal was successful
            System.out.println("Thread 1: Was Key 3 removed? " + removed); // Expected output: false

            // Printing the updated map to verify the removal attempt
            System.out.println("Thread 1: Updated Map -> " + map);
        });

        // Starting the thread
        thread1.start();

        // Ensuring the thread finishes execution before printing the final map state
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Printing final map state to confirm no unintended modifications occurred
        System.out.println("Final Map: " + map);
    }
}
