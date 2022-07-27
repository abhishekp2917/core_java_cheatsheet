package com.excercise.javaGenerics.GenericsBasics.example2;

// Using ArrayList object to store only String object with paramterized type (generics)

import java.util.ArrayList;

public class Test {
            
    public static void main(String[] args) {
        
        // creating ArrayList object with paramterized type (generics)
        ArrayList <String> l = new ArrayList <String> ();

        // adding string object
        l.add(new String("Ravi"));
        l.add(new String("Anvisha"));
        l.add(new String("Abhishek"));

        /*  
            by mistake adding object which is not of string type will give
            compile time error and thus provide type safety
        */
        // l.add(new Integer(10));

        /* 
            retrieving objects stored inside ArrayList expecting it to be of only
            string type

            Here due to generics we get assurance that we will get only String 
            type object

            moreover, we don't need to type cast this object
        */
        System.out.println(l.get(0));
        System.out.println(l.get(1));
        System.out.println(l.get(2));
    }
}
