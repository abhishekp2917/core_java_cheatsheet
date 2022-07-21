package com.excercise.javaInstanceControlFlow.InstanceControlFlowBasics.example2;

public class Parent {

    int i = 100;

    {
        System.out.println(i);

        System.out.println("Parent instance block");
    }

    Parent() {

        System.out.println("Parent constructor");
    }

    public static void main(String[] args) {

        Parent p = new Parent();

        p.method1();

        System.out.println("Parent main method");
    }

    public void method1() {

        System.out.println(j);
    }

    int j = 200;
}
