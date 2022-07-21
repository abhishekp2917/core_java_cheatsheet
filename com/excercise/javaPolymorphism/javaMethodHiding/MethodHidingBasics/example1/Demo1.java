package com.excercise.javaPolymorphism.javaMethodHiding.MethodHidingBasics.example1;

public class Demo1 {
    
    public static void main(String[] args) {
        
        // creating parent object with parent reference
        // Parent p1 = new Parent();

        // creating child object with child reference
        // Child c1 = new Child();

        // creating child object with parent reference
        // Parent p2 = new Child();

        // method hiding example

        // since p1 is parent reference type, parent static method method1 will be invoked 
        // p1.method1();

        // since c1 is child reference type, child static method method1 will be invoked 
        // c1.method1();

        // since p2 is parent reference type, parent static method method1 will be invoked 
        // p2.method1();
    }
}
