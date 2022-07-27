package com.excercise.javaInnerClass.AnnonymousInnerClass.example3;

// defining annonymous inner class inside an argument

// defining Person abstract class 
abstract class Person {

    abstract void intro();
}

// defining Test class
class Test {

    // static method to print person info
    public static void printInfo(Person p) {

        // calling person intro method
        p.intro();
    }

    public static void main(String[] args) {

        // calling Test class static method that accepts person object
        Test.printInfo(
            
            /*
                defining annonymous inner class inside an argument that extends 
                Person class
            */
            new Person() {

                // overriding Person abstract class intro method
                @Override
                void intro() {

                    System.out.println("Hello! How are you");
                }                
            }
        );
    }
}
