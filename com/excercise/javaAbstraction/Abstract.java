package com.excercise.javaAbstraction;


// _________________________abstract class without constructor______________________________

// abstract person class
abstract class Person{

    String name;
    int age;
    float weight;
}

// student class extends person class
class Student extends Person{

    int rollNumber;
    float percentage;

    // Student constructor
    Student(String name, int age, float weight, int rollNumber, float percentage){
        // Person properties
        // redundancy of code
        this.name = name;
        this.age = age;
        this.weight = weight;
        // Student properties
        this.rollNumber = rollNumber;
        this.percentage = percentage;
    }
}

// teacher class extends person class
class Teacher extends Person{

    double salary;
    String subjects;

    // Student constructor
    Teacher(String name, int age, float weight, double salary, String subjects){
        // Person properties
        // redundancy of code
        this.name = name;
        this.age = age;
        this.weight = weight;
        // Teacher properties
        this.salary = salary;
        this.subjects = subjects;
    }
}


// ____________________________abstract class with constructor______________________________

// abstract animal class
abstract class Animal{

    String name;
    float weight;
    float height;

    // abstract class constructor to reduce code redundancy
    Animal(String name, float weight, float height){
        // initialize animal class properties
        this.name = name;
        this.weight = weight;
        this.height = height;
    }
}

// dog class extends animal class
class Dog extends Animal{

    int legs;
    String breed;

    // dog class constructor
    Dog(String name, float weight, float height, int legs, String breed){
        // initialize animal class properties
        super(name, weight, height);
        // initialize dog class properties
        this.legs = legs;
        this.breed = breed;
    }
}

// fish class extends animal class
class Fish extends Animal{

    int fins;
    String type;

    Fish(String name, float weight, float height, int fins, String type){
        // initialize animal class properties
        super(name, weight, height);
        // initialize fish class properties
        this.fins = fins;
        this.type = type;
    }
}


// _________________________using abstract class instead of interface ________________________


abstract class PetAnimal{

    // declaring variable as public, static and final as all the interface properties are of same type by default
    public static final boolean isDangerous = false;

    // declaring all the method as abstract, public as all the interface methods are of same type by default
    abstract protected void speak();
    abstract public void eat();
}


interface WildAnimal{

    // interface properties are public, static and final by default
    boolean isDangerous = true;

    // interface methods are public and abstract by default
    void speak();
    void eat();
    void kill();
}















public class Abstract{

    public static void main(String[] args){

        Student s1 = new Student("Abhishek Pandey", 21, 61.05f, 10, 83.17f);
        Teacher t1 = new Teacher("Mitesh Patel", 44, 80.7f, 1000000.5, "Maths");

        System.out.println(s1.name);
        System.out.println(t1.name);

        Dog d1 = new Dog("Tommy", 20.1f, 100.5f, 4, "German Shepherd");
        Fish f1 = new Fish("katana", 0.4f, 5.1f, 2, "Gold fish");

        System.out.println(d1.name);
        System.out.println(f1.name);
    } 
}