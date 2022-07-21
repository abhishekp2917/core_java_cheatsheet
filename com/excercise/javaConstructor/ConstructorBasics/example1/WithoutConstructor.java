package com.excercise.javaConstructor.ConstructorBasics.example1;

// Student class without explicit constructor
class Student {

    String name;
    int rollNumber;
}

public class WithoutConstructor {

    public static void main(String[] args) {

        // creating student object
        Student s1 = new Student();
        Student s2 = new Student();

        // code redundancy due to not using constructor for initialization of object

        // initializing student object
        s1.name = "Sanjana";
        s1.rollNumber = 20;

        s2.name = "Yash";
        s2.rollNumber = 17;
    }
}

