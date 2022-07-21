package com.excercise.javaPolymorphism.javaMethodOverloading.MethodOverloadingBasics.example5;

public class Demo5 {
    
    public static void main(String[] args) {
        
        // creating Test5 class object
        Test5 t = new Test5();

        // method overloading example 
        
        // invoking method1 with float int argument will invoke method with signature method1(float, int)
        t.method1(10f, 10);
        // invoking method1 with int float argument will invoke method with signature method1(int, float)
        t.method1(10, 10f);
        /*
            invoking method1 with int int argument will result in method ambiguity as for method
            signature method1(int, float), due to automatic promotion second int 
            argument wlll convert into float. Similarly for method signature 
            method1(float, int), due to automatic promotion first int argument wlll 
            convert into float. As both the method satisfied and thus result in 
            ambiguity due to which compiler will give comiple time error.
        */
        // t.method1(10, 10);
    }
}
