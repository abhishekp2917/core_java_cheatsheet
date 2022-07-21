package com.excercise.javaPolymorphism.javaMethodOverloading.MethodOverloadingBasics.example7;

public class Demo7 {
    
    public static void main(String[] args) {
        
        // creating Test7 class object
        Test7 t = new Test7();

        // Animal object with Animal reference
        Animal a1 = new Animal();
        // Dog object with Dog reference
        Dog d1 = new Dog();
        // Dog object with Animal reference
        Animal a2 = new Dog();

        // method overloading example 
        
        // invoking method1 with Animal object having Animal reference argument will invoke method with signature method1(Animal)
        t.method1(a1);
        /* 
            invoking method1 with Dog object having Dog reference argument will invoke 
            method with signature method1(Dog)

            Here method with signature method1(Animal) also satisfies the argument but 
            since in method overloading Child argument type gets higher priority than
            Parent argument type, method with signature method1(Dog) will get executed 
        */
        t.method1(d1);
        /*
            invoking method1 with Dog object having Animal reference argument will 
            invoke method with signature method1(Animal) becuase in method overloading
            method resolution always take cares by compiler based on object reference
            type and not based on object type.
        */
        t.method1(a2);
    }
}
