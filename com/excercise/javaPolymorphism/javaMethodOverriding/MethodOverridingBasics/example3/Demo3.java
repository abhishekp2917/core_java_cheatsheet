package com.excercise.javaPolymorphism.javaMethodOverriding.MethodOverridingBasics.example3;

import java.io.IOException;

public class Demo3 {
    
    public static void main(String[] args) {
        
        // creating Child object with Parent reference
        Parent p1 = new Child();

        try{
            p1.method1();
        }
        catch(Exception e) {
            e.getMessage();
        }

        try{
            p1.method2();
        }
        catch(IOException e) {
            e.getMessage();
        }

        try{
            p1.method3();
        }
        catch(IOException e) {
            e.getMessage();
        }

        try{
            p1.method4();
        }   
        catch(IOException e) {
            e.getMessage();
        }

        p1.method5();

        p1.method6();
    }
}
