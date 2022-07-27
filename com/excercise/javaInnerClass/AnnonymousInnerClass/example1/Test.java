package com.excercise.javaInnerClass.AnnonymousInnerClass.example1;

// annonymous inner class that extends other class

// defining Person abstract class
abstract class Person {

    // instance variable
    String name;

    // abstract method
    public abstract void speak();
}

// defining Test class
public class Test {

    public static void main(String[] args) {

        /*
            creating annonymous inner class that extends Person class which is for 
            one time use only

            this annonymous class has parent class reference that's why even though 
            we can declare new variable and method inside this annonymous class we 
            can access only parent class members and not this class specific members 
        */
        Person p = new Person() {

            String introSpeech = "Hello! How are you ?";

            // define speak method 
            @Override
            public void speak() {

                System.out.println(introSpeech);
            } 
        };

        // calling 'speak' method of annonymous inner class that extends Person class
        p.speak();
    }
}