package com.excercise.javaPolymorphism.javaMethodOverloading.MethodOverloadingBasics.example6;

public class Demo6 {
    
    public static void main(String[] args) {
        
        // creating Test6 class object
        Test6 t = new Test6();

        // method overloading example 
        
        // invoking method1 with no argument will invoke method with signature method1(int...)
        t.method1();
        // invoking method1 with multiple int argument will invoke method with signature method1(int...)
        t.method1(10, 10);
        /*
            invoking method1 with one int argument will invoke method with signature 
            method1(int).

            here method with signature method1(int...) also satisfies the argument 
            passed but since varargs concept came in later version of java, compiler
            will execute method with signature method1(int) 
        */
        t.method1(10);
    }
}
