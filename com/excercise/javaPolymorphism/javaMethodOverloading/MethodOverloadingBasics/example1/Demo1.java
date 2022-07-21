package com.excercise.javaPolymorphism.javaMethodOverloading.MethodOverloadingBasics.example1;

public class Demo1 {
    
    public static void main(String[] args) {
        
        // creating Test1 class object
        Test1 t = new Test1();

        // method overloading example 
        
        // invoking method1 with no arguments
        t.method1();
        // invoking method1 with int argument
        t.method1(10);
        // invoking method1 with float argument
        t.method1(10.0f);
    }
}
