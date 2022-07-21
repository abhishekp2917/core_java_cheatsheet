package com.excercise.javaInheritance.InheritanceBasics;

public class Demo1 {
    
    public static void main(String[] args) {
        
        // creating parent object with parent reference
        Parent p = new Parent();
        // creating child object with child reference
        Child c = new Child();
        // creating grandChild object with GrandChild reference
        GrandChild gc = new GrandChild();

        // parent reference has access to only its own methods and not its child methods
        p.method1();
        // p.method2();

        // child reference has access to both parent and child object methods
        c.method1();
        c.method2();

        // grandChild reference has access to parent, child and grandChild object methods
        gc.method1();
        gc.method2();
        gc.method3();
    }
}
