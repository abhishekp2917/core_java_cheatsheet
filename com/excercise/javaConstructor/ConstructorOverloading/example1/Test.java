package com.excercise.javaConstructor.ConstructorOverloading.example1;

// class Test having overloaded constructors
public class Test {

    double x = 10;
    
    // no argument constructor
    Test() {
        // using 'this()' at first line inside constructor 
        this(10);
        System.out.println("no argument constructor");
    }

    // constructor with 'int' argument constructor
    Test(int i) {
        // using 'this()' at first line inside constructor
        this(10.0);
        this.x = i;
        System.out.println("int argument constructor");
    }

    // constructor with 'double' argument constructor
    Test(double d) {
        this.x = d;
        System.out.println("double argument constructor");
    }

    public static void main(String[] args) {

        // constructor overloading example

        System.out.println("\n________Calling no argument constructor________\n");

        // creating Test object which will call no argument Test constructor
        Test t1 = new Test();
        System.out.println(t1.x);

        System.out.println("\n________Calling int argument constructor________\n");

        // creating Test object which will call 'int' argument Test constructor
        Test t2 = new Test(20);
        System.out.println(t2.x);

        System.out.println("\n________Calling double argument constructor________\n");

        // creating Test object which will call 'double' argument Test constructor
        Test t3 = new Test(30.0);
        System.out.println(t3.x);
    }
}
