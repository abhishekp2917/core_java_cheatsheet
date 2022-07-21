package com.excercise.javaInstanceControlFlow.InstanceControlFlowBasics.example2;

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

    private void method2() {

        System.out.println(y);
    }

    {
        method2();
        
        System.out.println("Child second instance block");
    }

    int y = 20;
}
