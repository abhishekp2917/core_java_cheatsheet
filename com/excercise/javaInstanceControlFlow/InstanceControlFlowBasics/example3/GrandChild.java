package com.excercise.javaInstanceControlFlow.InstanceControlFlowBasics.example3;

public class GrandChild extends Child {
    
    int a = 1;

    {
        method3();

        System.out.println("GrandChild first instance block");
    }

    GrandChild() {
        
        System.out.println("GrandChild constructor");
    }

    public static void main(String[] args) {

        GrandChild gc = new GrandChild();

        gc.method3();

        System.out.println("GrandChild main method");
    }

    public void method3() {

        System.out.println(b);
    }

    {
        System.out.println("GrandChild second instance block");
    }

    int b = 2;
}
