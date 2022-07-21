package com.excercise.javaInstanceControlFlow.InstanceControlFlowBasics.example4;

public class Test {
    
    static int i = 100;

    int x = 10;

    static {

        System.out.println(i);

        System.out.println("First static block");
    }

    {
        System.out.println(x);

        System.out.println("First instance block");
    }

    Test() {

        System.out.println("Constructor");
    }

    public static void main(String[] args) {
        
        Test t = new Test();

        t.method2();

        System.out.println("Main method");
    }

    public static void method1() {

        System.out.println(j);
    }

    public void method2() {

        System.out.println(y);
    }
    static {

        System.out.println(Test.j);

        System.out.println("Second static block");
    }

    {
        System.out.println(this.y);

        System.out.println("Second instance block");
    }

    static int j = 200;

    int y = 20;
}
