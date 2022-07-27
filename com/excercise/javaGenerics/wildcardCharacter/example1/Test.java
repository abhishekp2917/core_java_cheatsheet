package com.excercise.javaGenerics.wildcardCharacter.example1;

// generic methods with wildcard character

import java.util.ArrayList;

public class Test {

    
    // this method can we called by passing ArrayList object of String type only
    public void method1(ArrayList <String> list) {

        // we can add only null and String type object in given ArrayList
        list.add("String");
        list.add(null);

        System.out.println("method1");
    }

    // this method can we called by passing ArrayList object of Number type only
    public void method2(ArrayList <Number> list) {

        // we can add only null and Number type object in given ArrayList
        list.add(10);
        list.add(10.0f);
        list.add(10.0);
        list.add(null);

        System.out.println("method2");
    }

    // this method can we called by passing ArrayList object of any type only
    public void method3(ArrayList <?> list) {

        // we can add only null in given ArrayList which uses wildcard character
        list.add(null);

        System.out.println("method3");
    }

    /*
        this method can we called by passing ArrayList object of Number or its 
        child type only 
    */
    public void method4(ArrayList <? extends Number> list) {

        // we can add only null in given ArrayList which uses wildcard character
        list.add(null);

        System.out.println("method4");
    }

    /* 
        this method can we called by passing ArrayList object of Runnable or its 
        implementation type only
    */
    public void method5(ArrayList <? extends Runnable> list) {

        // we can add only null in given ArrayList which uses wildcard character
        list.add(null);

        System.out.println("method5");
    }

    /*
        this method can we called by passing ArrayList object of Integer or its 
        super class type only
    */
    public void method6(ArrayList <? super Integer> list) {

        /* 
            we can add only null and Integer object in given ArrayList which uses 
            wildcard character
        */
        list.add(10);
        list.add(null);

        System.out.println("method6");
    }

    /* 
        this method can we called by passing ArrayList object of Runnable or super 
        class of Runnable implementation type only
    */
    public void method7(ArrayList <? super Runnable> list) {

        /* 
            we can add only null and Runnable object in given ArrayList which uses 
            wildcard character
        */
        list.add(
            
            new Runnable() {

                @Override
                public void run() {
                    System.out.println("Running child thread");
                }
            }
        );

        System.out.println("method7");
    }

    public static void main(String[] args) {
        
        Test t = new Test();

        t.method1(new ArrayList <String> ());

        System.out.println();

        t.method2(new ArrayList <Number> ());

        System.out.println();

        t.method3(new ArrayList <Integer>());
        t.method3(new ArrayList <Double>());
        t.method3(new ArrayList <Object>());
        t.method3(new ArrayList <Runnable>());

        System.out.println();

        t.method4(new ArrayList <Number>());
        t.method4(new ArrayList <Integer>());
        t.method4(new ArrayList <Double>());

        System.out.println();

        t.method5(new ArrayList <Runnable> ());
        t.method5(new ArrayList <Thread> ());

        System.out.println();

        t.method6(new ArrayList <Integer> ());
        t.method6(new ArrayList <Number> ());

        System.out.println();

        t.method7(new ArrayList <Runnable> ());
    }
}