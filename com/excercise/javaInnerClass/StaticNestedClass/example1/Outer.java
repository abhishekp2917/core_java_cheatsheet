package com.excercise.javaInnerClass.StaticNestedClass.example1;

// accessing static nested class members from outer class main method

// defining outer class
public class Outer {

    // defining static nested class
    static class Inner {

        // static nested class instance variable
        String s1 = "Static nested class instance variable";

        // static nested class static variable
        static String s2 = "Static nested class static variable";

        // static nested class instance method
        void method1() {

            System.out.println("Static nested class instance method");
        }

        // static nested class static method
        static void method2() {

            System.out.println("Static nested class static method");
        }

        // static nested class main method
        public static void main(String[] args) {

            System.out.println("Static nested class main method");
        }
    }

    // outer class main method
    public static void main(String[] args) {

        // creating object of static nested class from inside of outer class main method
        Inner i = new Inner();

        // accessing static nested class instance variable
        System.out.println(i.s1);

        // accessing static nested class static variable
        System.out.println(Inner.s2);

        // calling static nested class instance method
        i.method1();

        // calling static nested class static method
        Inner.method2();

        // calling static nested class main method
        Inner.main(new String[0]);
    }
}