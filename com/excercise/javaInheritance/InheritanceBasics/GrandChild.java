package com.excercise.javaInheritance.InheritanceBasics;

/* 
    GrandChild class extends Child class and thus inherits Child class methods as 
    well as parent class methods 

    This is knwon as multi-level inheritance
*/
public class GrandChild extends Child {
    
    public void method3() {
        System.out.println("GrandChild method");
    }
}
