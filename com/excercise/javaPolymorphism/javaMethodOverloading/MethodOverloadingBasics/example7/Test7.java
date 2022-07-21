package com.excercise.javaPolymorphism.javaMethodOverloading.MethodOverloadingBasics.example7;

class Animal {

}

class Dog extends Animal {

}


public class Test7 {
    
    public void method1(Animal a) {
        System.out.println("method1 with Animal object argument");
    }

    public void method1(Dog d) {
        System.out.println("method1 with Dog object argument");
    }
}
