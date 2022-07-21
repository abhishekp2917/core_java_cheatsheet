package com.excercise.javaStaticControlFlow.StaticControlFlowBasics.example2;

public class Child extends Parent {

    static int x = 10;

    static {

        method2();

        System.out.println("Child first static block");
    }

    public static void main(String[] args) {

        method2();

        System.out.println("Child main method");
    }

    private static void method2() {

        System.out.println(y);
    }

    static {

        System.out.println("Child second static block");
    }

    static int y = 20;
}
