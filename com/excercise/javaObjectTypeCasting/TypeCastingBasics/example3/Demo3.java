package com.excercise.javaObjectTypeCasting.TypeCastingBasics.example3;

public class Demo3 {
    
    public static void main(String[] args) {
        
        // creating String object with Object reference type
        Object o = new String("Hello world");

        
        /* 
            type casting String object with Object reference type into StringBuffer 
            type and assigning it to reference variable of StringBuffer type


            below type casting violates Condition-I of JVM because runtime object 
            of 'o' is String and we are trying it to convert into StringBuffer type
            which is not valid

            JVM will throw ClassCastException
        */
        StringBuffer sb = (StringBuffer) o;
        System.out.println(sb);
    }
}
