package com.excercise.javaPolymorphism.javaMethodOverloading.MethodOverloadingBasics.example1;

/* 
    Class Test have method named 'method1' which is overloaded by different method
    signature
*/
public class Test1 {
    
    public void method1() {
        System.out.println("method with no arguments");
    }

    public void method1(int n) {
        System.out.println("method with int argument");
    }

    public void method1(float f) {
        System.out.println("method with float arguments");
    }
}
