package com.excercise.javaInnerClass.AnnonymousInnerClass.example2;

// annonymous inner class that implements interface

// defining Person interface
interface Person {

    // abstract method
    public abstract void speak();
}

// defining Test class
public class Test {

    public static void main(String[] args) {

        /*
            creating annonymous inner class that implements Person interface which 
            is for one time use only

            this annonymous class has parent class reference that's why even though 
            we can declare new variable and method inside this annonymous class we 
            can access only parent class members and not this class specific members 
        */
        Person p = new Person() {

            String name = "Anjali";

            // overriding speak method of Person interface
            @Override
            public void speak() {

                System.out.println("My name is " + this.name);
            } 
        };

        // calling 'speak' method of annonymous inner class that implements Person interface
        p.speak();
    }
}