package com.excercise.javaInstanceControlFlow.InstanceControlFlowBasics.example3;

public class Child extends Parent {

    int x = 10;

    {
        System.out.println(this.y);

        System.out.println("Child first instance block");
    }

    Child() {
        
        System.out.println("Child constructor");
    }

    public static void main(String[] args) {

        Child c = new Child();

        c.method2();

        System.out.println("Child main method");
    }

    public void method2() {

        System.out.println(y);
    }

    int y = 20;
}
