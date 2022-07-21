package com.excercise.javaInstanceControlFlow.InstanceControlFlowBasics.example1;

public class Demo1 {
    
    // instance variable of type int 
    int i = 10;

    // instance block
    {
        // printing value of instance variable 'i'
        System.out.println(i);

        // printing some output
        System.out.println("First instance block");
    }

    // Demo1 class constructor
    Demo1() {

        // printing some output
        System.out.println("Constructor");
    }

    // static main method
    public static void main(String[] args) {

        // creating object of Demo1 class with Demo1 type reference
        Demo1 d = new Demo1();

        // calling Demo1 class instance method
        d.method1();

        // printing some output
        System.out.println("Main method");
    }

    // instance method
    public void method1() {

        System.out.println(j);
    }

    // instance block
    {
        // calling instance method method1()
        method1();

        System.out.println("Second static block");
    }

    // instance variable of type int
    int j = 20;
}
