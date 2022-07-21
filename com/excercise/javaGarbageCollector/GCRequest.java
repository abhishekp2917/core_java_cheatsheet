package com.excercise.javaGarbageCollector;

class Person{

    static int id;
    String name;
    int age;

    Person(String name, int age){
        this.name = name;
        this.age = age;
        id += 1;
    }

    public void dummyMethod(){

    }
}

public class GCRequest {
    
    public static void main(String[] args){

        Runtime r = Runtime.getRuntime();

        // printing memory info before creating objects
        System.out.println("Total Memory : "+r.totalMemory());
        System.out.println("Free Memory : "+r.freeMemory()+"\n");
        
        System.out.println("\n____________using System gc() to request GC______________\n");

        for(int i=0; i<1000000; ++i){
            // creating student object
            Person p = new Person("Abhishek Pandey", 21);
            p.dummyMethod();
            //  nullifying student object reference making object eligible for GC
            p = null;
        }

        // printing memory info after creating objects
        System.out.println("Free Memory after object creation: "+r.freeMemory());

        // request GC
        System.gc();

        // printing memory info after requesting GC
        System.out.println("Free Memory after requesting GC through System : "+r.freeMemory());




        // ____________________________________________________________________________________

        System.out.println("\n____________using Runtime gc() to request GC______________\n");

        for(int i=0; i<1000000; ++i){
            // creating student object
            Person p = new Person("Abhishek Pandey", 21);
            p.dummyMethod();
            // nullifying student object reference making object eligible for GC
            p = null;
        }

        // printing memory info after creating objects
        System.out.println("Free Memory after object creation: "+r.freeMemory());

        r.gc();

        // printing memory info after requesting GC
        System.out.println("Free Memory after requesting GC througn Runtime : "+r.freeMemory());
    }
}
