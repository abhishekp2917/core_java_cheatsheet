package com.excercise.javaObjectTypeCasting.TypeCastingBasics.example5;

public class Demo5 {
    
    public static void main(String[] args) {
        
        // creating GrandChild obejct with with GrandChild reference
        GrandChild gc = new GrandChild();

        // calling Parent method from GrandChild reference
        gc.method1();

        /* 
            calling Child method from Child reference after converting GrandChild 
            reference to Child reference
        */
        ((Child)gc).method1();

        /* 
            calling Parent method from Parent reference after converting GrandChild 
            reference to Child reference and then from Child to Parent reference
        */
        ((Parent)((Child)gc)).method1();

        /* 
            calling Parent method from Parent reference after converting GrandChild 
            reference to Parent reference 
        */
        ((Parent)gc).method1();
    }
}
