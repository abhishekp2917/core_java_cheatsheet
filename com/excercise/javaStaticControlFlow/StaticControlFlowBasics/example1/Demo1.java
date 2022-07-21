package com.excercise.javaStaticControlFlow.StaticControlFlowBasics.example1;

public class Demo1 {
    
    // static variable of type int 
    static int i = 10;

    // static block
    static {
        // indirectly reading static variable which is in RIWO mode 
        System.out.println(Demo1.j);

        // calling static method method1
        method1();

        // printing some output
        System.out.println("First static block");
    }
    // static main method
    public static void main(String[] args) {

        // calling static method1
        method1();

        System.out.println("Main method");
    }

    // static method
    private static void method1() {

        System.out.println(j);
    }

    // static block
    static {

        System.out.println("Second static block");
    }

    // static variable of type int
    static int j = 20;
}
