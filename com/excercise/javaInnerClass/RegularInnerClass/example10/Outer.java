package com.excercise.javaInnerClass.RegularInnerClass.example10;

/* 
    inner class inheriting class and interface outside of outer class 
*/

// student class
class Student {

    // instance variables
    String name;
    int marks;

    // student constructor
    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

// person interface
interface Person {

    void personMethod();

}

// outer class
public class Outer {
    
    // inner class extending and implementing class and interface outside of outer class 
    class Inner extends Student implements Person {

        Inner(String name, int marks) {
            super(name, marks);
        }

        // inner class instance method
        void getInfo() {

            // accessing student class instance variables
            System.out.println(super.name + " : " + super.marks);
        }

        // implentation of Person interface method
        @Override
        public void personMethod() {
            System.out.println("Implementation of person method");
        }
    }

    public static void main(String[] args) {
        
        // creating inner class object using outer class object
        Outer.Inner i = new Outer().new Inner("Anjali", 80);

        // calling inner class instance method
        i.getInfo();

        // calling inner class instance method
        i.personMethod();
    }
}
