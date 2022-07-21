package com.excercise.javaInheritance.InheritanceBasics;

public class Demo2 {
    
    public static void main(String[] args) {
        
        // creating child object with parent reference
        Parent p = new Child();

        // child object with parent reference has access to only parent methods
        p.method1();
        // child object with parent reference has not access to child methods
        // p.method2();
    }
}
