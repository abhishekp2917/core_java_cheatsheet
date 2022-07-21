package com.excercise.javaObjectTypeCasting.TypeCastingBasics.example1;

public class Demo1 {
    
    public static void main(String[] args) {
        
        // creating String object with String reference type
        // String s = new String("Hello world");

        
        /* 
            type casting String object with String reference type into StringBuffer 
            type and assigning it to reference variable of StringBuffer type


            below type casting violates Condition-I of compiler because 's' is of 
            String type and we are trying to convert it into StringBuffer type and 
            there is no relation between String and StringBuffer

            compiler will give inconvertible type error
        */
        // StringBuffer sb = (StringBuffer) s;
    }
}