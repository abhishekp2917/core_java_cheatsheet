package com.excercise.javaPolymorphism.javaMethodOverloading.MethodOverloadingBasics.example8;

public class Test8 {
    
    // static method with method signature method1(int)
    public static void method1(int n) {
        System.out.println("static method with int argument");
    }

    // static overloaded method with method signature method1(float)
    static void method1(float n) {
        System.out.println("static method with float argument");
    }
}
