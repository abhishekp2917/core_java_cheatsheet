package com.excercise.javaStaticControlFlow.StaticControlFlowBasics.example3;

public class GrandChild extends Child {
    
    static int a = 1;

    static {

        method3();

        System.out.println("GrandChild first static block");
    }

    public static void main(String[] args) {

        method3();

        System.out.println("GrandChild main method");
    }

    private static void method3() {

        System.out.println(b);
    }

    static {

        System.out.println("GrandChild second static block");
    }

    static int b = 2;
}
