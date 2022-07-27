package com.excercise.javaInnerClass.MethodLocalInnerClass.example1;

// method local inner class example


// outer class 
public class Outer {

    // outer class instance method
    void method1() {

        // method local inner class 
        class Inner {

            // inner class instance method
            void method2() {
                
                System.out.println("Method local inner class instance method");
            }
        }

        System.out.println("Outer class instance method");

        /*
            creating method local inner class object so that we can call its method
            repeatedly to avoid code redundancy
        */
        Inner i = new Inner();

        // calling method local inner class instance method
        i.method2();

        // calling method local inner class instance method
        i.method2();
        
        // calling method local inner class instance method
        i.method2();
    }

    public static void main(String[] args) {
        
        // creating outer class object
        Outer o = new Outer();

        // calling outer class instance method 
        o.method1();
    }
}
