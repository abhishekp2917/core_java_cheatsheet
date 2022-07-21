package com.excercise.javaPolymorphism.javaMethodOverloading.MethodOverloadingBasics.example3;

public class Demo3 {
    
    public static void main(String[] args) {
        
        // creating Test3 class object
        Test3 t = new Test3();

        // method overloading example 
        
        // invoking method1 with String argument will invoke method with signature method1(String)
        t.method1("string");
        // invoking method1 with Object argument will invoke method with signature method1(Object)
        t.method1(new Object());
        /*
            invoking method1 with null argument will invoke method with signature method1(String)
            
            here null argument is valid for String as well as Object but since String is a child
            of Object, therefore method with String parameter will get invoked 
        */
        t.method1(null);
        
    }
}
