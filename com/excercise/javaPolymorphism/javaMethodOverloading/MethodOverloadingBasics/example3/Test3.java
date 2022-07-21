package com.excercise.javaPolymorphism.javaMethodOverloading.MethodOverloadingBasics.example3;

public class Test3 {
    
    public void method1(String s) {
        System.out.println("method1 with String argument");
    }

    public void method1(Object o) {
        System.out.println("method1 with Object argument");
    }
}
