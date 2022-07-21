package com.excercise.javaGarbageCollector;

class Student{

    static int id;
    String name;
    int age;

    Student(String name, int age){
        this.name = name;
        this.age = age;
        id += 1;
    }
}

public class GCBasics {
    
    public static void main(String[] args){

        System.out.println("\n_____________Nullifying the refernce variable____________\n");

        // creating student objects
        Student s1 = new Student("Abhishek", 21);
        Student s2 = new Student("Ravi", 22);

        System.out.println("s1 hashcode: "+s1.hashCode());
        System.out.println("s2 hashcode: "+s2.hashCode());

        /*  nullifying the student reference variable 
            after which these objects are eligible for Garbage Collection 
        */
        s1 = null;
        s2 = null;




        // _____________________________________________________________________________________

        System.out.println("\n_____________Reassigining the refernce variable____________\n");

        // creating student object and assigning it to s3 refernce variable
        Student s3 = new Student("Saurabh", 21);

        /*  reassigning s3 reference variable
            after which student object with name 'Saurabh' will become eligible
            for Garbage Collection 
        */ 
        s3 = new Student("Anjali", 20);

        System.out.println("s3 hashcode: "+s3.hashCode());




        // _____________________________________________________________________________________

        System.out.println("\n_____________creating object inside the method____________\n");

        // calling static method 'method1()'
        method1();

        // calling static method 'method2()'
        Student s4 = method2();

        System.out.println("s4 hashcode: "+s4.hashCode());


    }

    public static void method1(){

        // creating student object
        Student s = new Student("Abhishek", 21);
        System.out.println("s hashcode: "+s.hashCode());

    }
    // after this method object 's' is eligible for Garbage Collections


    public static Student method2(){

        // creating student objects
        Student s1 = new Student("Abhishek", 21);
        Student s2 = new Student("Tushar", 21);

        System.out.println("s1 hashcode: "+s1.hashCode());
        System.out.println("s2 hashcode: "+s2.hashCode());

        return s2;
    }
    /*  after this method object 's1' is eligible for Garbage Collections
        but since object 's2' got new reference which is outside of this method 
        object 's2' isn't eliginble for Grabage Collections
    */
}

