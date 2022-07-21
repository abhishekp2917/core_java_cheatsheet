package com.excercise.javaPolymorphism.javaMethodOverriding.MethodOverridingBasics.example2;

public class Child extends Parent {
    
    @Override
    public String method1() {
        System.out.println("Child implementation with String as return type");
        return new String();
    }
}
