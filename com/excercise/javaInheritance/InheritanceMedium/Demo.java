package com.excercise.javaInheritance.InheritanceMedium;

public class Demo {
    
    public static void main(String[] args){

        /* 
            creating object of class Dog with Dog class reference

            it won't create pet (parent) class objects but surely will call pet 
            class constructor and since both pet and dog class constructor is 
            printing hashcode of object which is created, we will get it as output  

        */
        Dog d1 = new Dog("Tommy", 24.5f, 2, "Golden Retriever", "America", 4);

        // printing hascode of object 'd1' of type Dog
        System.out.println(d1.hashCode());
    }
}
