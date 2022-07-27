package com.excercise.javaInnerClass.MethodLocalInnerClass.example3;

/* 
    declaring method local inner class inside outer class instance method

    In this case we can access only outer class static variable 
*/

// outer class 
public class Outer {

    // outer class instance variable
    int x = 20;

    // outer class static variable
    static int y = 30;

    // outer class instance method
    static void method1() {

        // method local inner class inside outer class instance method
        class Inner {

            // inner class instance method
            void method2() {
                
                // accessing outer class instance method
                System.out.println(y);

                // we can't access outer class static method
                // System.out.println(x);
            }
        }

        /*
            creating method local inner class object so that we can call instance
            method of method local inner class
        */
        Inner i = new Inner();

        // calling method local inner class instance method
        i.method2();
    }
}