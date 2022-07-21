package com.excercise.javaPolymorphism.javaMethodOverloading.MethodOverloadingBasics.example2;

public class Demo2 {
    
    public static void main(String[] args) {
        
        // creating Test2 class object
        Test2 t = new Test2();

        // method overloading example 
        
        // invoking method1 with int argument will invoke method with signature method1(int)
        t.method1(10);
        // invoking method1 with float argument will invoke method with signature method1(float)
        t.method1(10.0f);
        // invoking method1 with char argument will invoke method with signature method1(int)
        t.method1('a');
        // invoking method1 with byte argument will invoke method with signature method1(int)
        t.method1((byte)1);
        // invoking method1 with short argument will invoke method with signature method1(int)
        t.method1((short)1);
        // invoking method1 with long argument will invoke method with signature method1(float)
        t.method1((long) 12);
        // invoking method1 with double argument will invoke method with signature method1(double)
        t.method1(12.0);
    }
}
