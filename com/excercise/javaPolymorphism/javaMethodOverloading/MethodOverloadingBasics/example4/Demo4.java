package com.excercise.javaPolymorphism.javaMethodOverloading.MethodOverloadingBasics.example4;

public class Demo4 {
    
    public static void main(String[] args) {
        
        // creating Test4 class object
        Test4 t = new Test4();

        // method overloading example 
        
        // invoking method1 with String argument will invoke method with signature method1(String)
        t.method1("string");
        // invoking method1 with StringBuffer argument will invoke method with signature method1(StringBuffer)
        t.method1(new StringBuffer());
        /*
            invoking method1 with null argument will result in method ambiguity as null is 
            valid for both String and StringBuffer but since both are at same level, compiler
            can't decide which method to execute and thus gives compile time error.
        */
        // t.method1(null);
    }
}
