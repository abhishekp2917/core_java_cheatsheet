package com.excercise.javaObjectTypeCasting.TypeCastingBasics.example2;

public class Demo2 {
    
    public static void main(String[] args) {
        
        // creating String object with Object reference type
        // Object o = new String("Hello world");

        
        /* 
            type casting String object with Object reference type into String 
            type and assigning it to reference variable of StringBuffer type


            below type casting violates Condition-II of compiler because 'o' is of 
            Object type and after type castiing it will be of String type and we are 
            trying to assign object of String type to reference variable of 
            StringBuffer type.

            Compiler will give incompatible type error
        */
        // StringBuffer sb = (String) o;
    }
}
