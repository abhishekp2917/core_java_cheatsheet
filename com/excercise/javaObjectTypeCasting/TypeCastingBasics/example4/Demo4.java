package com.excercise.javaObjectTypeCasting.TypeCastingBasics.example4;

public class Demo4 {
    
    public static void main(String[] args) {
        
        // creating Child obejct with with Child reference
        Child c = new Child();

        // calling Parent method from Child reference
        c.method1();

        // calling Child method from Child reference
        c.method2();

        /* 
            calling Child method from Child reference after type casting Child 
            reference to Parent reference and then type casting Parent reference 
            back to Child reference
        */
        ((Child)((Parent)c)).method2();

        /* 
            calling Parent method from Parent reference after type casting Child 
            reference to Parent reference 
        */
        ((Parent)c).method1();
    
        /* 
            calling Child method from Parent reference after type casting Child 
            reference to Parent reference 

            this will give compile time error since we can't call child specific 
            method from parent reference
        */
        // ((Parent)c).method2();
    }
}
