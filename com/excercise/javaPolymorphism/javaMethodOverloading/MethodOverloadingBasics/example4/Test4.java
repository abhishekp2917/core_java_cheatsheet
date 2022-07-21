package com.excercise.javaPolymorphism.javaMethodOverloading.MethodOverloadingBasics.example4;

public class Test4 {
    
    public void method1(String s) {
        System.out.println("method1 with String argument");
    }

    public void method1(StringBuffer sb) {
        System.out.println("method1 with StringBuffer argument");
    }
}

