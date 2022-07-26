package com.excercise.javaInnerClass.RegularInnerClass.example5;


// accessing outer class instance and static members from inner class

// creating outer class
public class Outer {

    // creating outer class instance and static method respectively
    int x = 10;
    static int y = 20;

    // creating outer class instance method
    public void outerInstanceMethod() {

        System.out.println("outer class instance method");
    }

    // creating outer class static method
    public static void outerStaticMethod() {

        System.out.println("outer class static method");
    }

    // creating inner class
    class Inner {

        // inner class instance method
        public void display() {

            // accessing outer class instance variable
            System.out.println(x);

            // accessing outer class static variable
            System.out.println(y);

            // accessing outer class instance method
            outerInstanceMethod();

            // accessing outer class static method
            outerStaticMethod();
        }
    }

    public static void main(String[] args) {

        // creating inner class object using outer class object
        Outer.Inner i = new Outer().new Inner();

        // calling inner class instance method
        i.display();
    }
}