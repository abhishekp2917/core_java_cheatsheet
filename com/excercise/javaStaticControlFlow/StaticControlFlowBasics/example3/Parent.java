package com.excercise.javaStaticControlFlow.StaticControlFlowBasics.example3;

public class Parent {

    static int i = 100;

    static {

        method1();

        System.out.println("Parent static block");
    }

    public static void main(String[] args) {

        method1();

        System.out.println("Parent main method");
    }

    private static void method1() {

        System.out.println(j);
    }

    static int j = 200;
}
