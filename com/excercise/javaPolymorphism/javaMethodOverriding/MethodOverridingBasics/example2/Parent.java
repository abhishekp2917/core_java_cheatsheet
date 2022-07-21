package com.excercise.javaPolymorphism.javaMethodOverriding.MethodOverridingBasics.example2;

public class Parent {
    
    // method1 with 'Object' as return type 
    public Object method1() {
        System.out.println("Parent implementation with Object as return type");
        return new Object();
    }
}
