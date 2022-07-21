package com.excercise.javaPolymorphism.javaMethodOverloading.MethodOverloadingBasics.example5;

public class Test5 {
    
    public void method1(float f, int n) {
        System.out.println("method1 with float int argument");
    }

    public void method1(int n, float f) {
        System.out.println("method1 with int float argument");
    }
}
