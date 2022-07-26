package com.excercise.javaInnerClass.RegularInnerClass.example9;

/* 
    inheritance in inner classes
*/

// outer class
public class Outer {
    
    // inner parent class
    class Parent {

        // inner parent class instance variable
        String s = "Parent";

        // inner parent class instance method
        void method1() {

            System.out.println("Parent inner class method");
        }
    }

    // inner child class
    class Child extends Parent {

        // inner child class instance variable
        String s = "Child";

        // inner child class instance method
        void method1() {

            System.out.println("Child inner class method");
        }
    }

    public static void main(String[] args) {
        
        // creating outer class object 
        Outer o = new Outer();

        // creating inner child class object from outer class object with inner parent reference
        Outer.Parent p = o.new Child();

        // calling method1() from inner parent reference
        p.method1();

        // accessing inner parent class instance variable
        System.out.println(p.s);

        // accessing inner child class instance varaible after casting parent reference to child reference
        System.out.println(((Outer.Child) p).s);
    }
}
