package com.excercise.javaPolymorphism.javaMethodOverloading.MethodOverloadingBasics.example8;

public class Demo8 {
    
    public static void main(String[] args) {
        
        // example of overloading static method 
        /* 
            calling static method with int argument which will invoke method with
            method signature method1(int)
        */ 
        Test8.method1(10);

        /* 
            calling static method with float argument which will invoke method with
            method signature method1(float)
        */ 
        Test8.method1(10.0f);
    }
}
