package com.excercise.javaGenerics.GenericsBasics.example1;

// Using ArrayList object to store only String object without paramterized type (generics)

// import java.util.ArrayList;

public class Test {

    @Override
    public String toString() {
        
        return "Test class";
    }
    
    public static void main(String[] args) {
        
        /*  
            creating ArrayList object without paramterized type (generics)
            
            in this list we want to add only string type object
        */
        // ArrayList l = new ArrayList();

        // adding string object
        // l.add(new String("Ravi"));
        // l.add(new String("Anvisha"));
        // l.add(new String("Abhishek"));

        /*  
            by mistake adding object which is not of string type 

            this doesn't provide type safety as we can add any type of object
        */
        // l.add(new Test());

        /* 
            retrieving objects stored inside ArrayList expecting it to be of only
            string type but we get Test type object as well

            this is why generics concept introduced to provide type safety and 
            solve type casting problems
        */
        // System.out.println(l.get(0));
        // System.out.println(l.get(1));
        // System.out.println(l.get(2));
        // System.out.println(l.get(3));
    }
}
