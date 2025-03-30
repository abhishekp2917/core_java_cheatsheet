package com.excercise.javaConcurrentCollections.ConcurrentHashMap.example1;

import java.util.concurrent.ConcurrentHashMap;

public class Test {
    public static void main(String[] args) {
        // Creating a ConcurrentHashMap
        // ConcurrentHashMap allows safe concurrent access in multi-threaded environments.
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();

        // Adding initial values to the map
        map.put(1, "Apple");
        map.put(2, "Banana");

        // Thread 1: Tries to use putIfAbsent to add new values
        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1: Trying putIfAbsent...");

            // putIfAbsent(K, V) will only add the key-value pair if the key is NOT already present in the map.
            map.putIfAbsent(2, "Grapes"); // Won't replace "Banana" since key 2 already exists
            
            map.putIfAbsent(3, "Cherry"); // Will add "Cherry" since key 3 is absent
            
            // Printing the updated map to verify the operation
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

        // Printing final map state to confirm changes
        System.out.println("Final Map: " + map);
    }
}
