package com.excercise.javaPolymorphism.javaMethodOverriding.MethodOverridingBasics.example2;

public class Demo2 {
 
    public static void main(String[] args) {
        
        // creating parent object with parent reference
        Parent p1 = new Parent();

        // creating child object with child reference
        Child c1 = new Child();

        /* 
            using parent object with parent reference to call method1 will invoke
            parent overriden method1 which return Object 
        */
        p1.method1();

        /* 
            using child object with child reference to call method1 will invoke
            child overriding method1 which retrun String 
        */
        c1.method1();
    }
}
