package com.excercise.javaConstructor.ConstructorBasics.example1;

// student class with constructor for initializing instance variables
class Student {

    String name;
    int rollNumber;

    Student(String name, int rollNumber) {
        // initializing instance variables
        this.name = name;
        this.rollNumber = rollNumber;
    }
}

public class WithConstructor {

    public static void main(String[] args) {

        // creating student object and initializing instance variables using constructors
        Student s1 = new Student("Sanjana", 20);

        Student s2 = new Student("Yash", 17);

        System.out.println(s1.name + " " + s1.rollNumber);
        System.out.println(s2.name  + " " + s2.rollNumber);
    }
}