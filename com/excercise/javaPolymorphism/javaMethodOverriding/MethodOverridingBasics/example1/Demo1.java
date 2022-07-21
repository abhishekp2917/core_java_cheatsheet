package com.excercise.javaPolymorphism.javaMethodOverriding.MethodOverridingBasics.example1;

public class Demo1 {
    
    public static void main(String[] args) {

        // creating parent object with parent reference
        Parent p1 = new Parent();

        // creating child object with child reference
        Child c1 = new Child();

        // creating child object with parent reference
        Parent p2 = new Child();

        /* 
            using parent object with parent reference to call method1 will invoke
            parent overriden method1 
        */
        p1.method1();

        /* 
            using child object with child reference to call method1 will invoke
            child overriding method1 
        */
        c1.method1();

        /* 
            using child object with parent reference to call method1 will invoke
            child overriding method1 

            this is because method overriding is resolved based on runtime object 
        */
        p2.method1();
    }
}
