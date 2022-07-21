package com.excercise.javaPolymorphism.javaMethodOverloading.MethodOverloadingBasics.example6;

public class Test6 {
    
    public void method1(int n) {
        System.out.println("method1 with int argument");
    }

    public void method1(int... n) {
        System.out.println("method1 with varargs int argument");
    }
}
