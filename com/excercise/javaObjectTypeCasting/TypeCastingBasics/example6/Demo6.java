package com.excercise.javaObjectTypeCasting.TypeCastingBasics.example6;

public class Demo6 {
    
    public static void main(String[] args) {
        
        // creating Child object with Child reference
        Child c = new Child();

        /* 
            calling Parent instance variable from Child reference
        */
        System.out.println(c.i);
        
        /* 
            calling Parent static variable from Child reference
        */
        // System.out.println(c.j);

        /* 
            calling Child instance variable from Child reference
        */
        System.out.println(c.x);
        
        /* 
            calling Child static variable from Child reference
        */
        // System.out.println(c.y);
        
        /* 
            calling Parent instance variable from Parent reference after converting 
            Child reference to Parent reference
        */
        System.out.println(((Parent)c).i);
        
        /* 
            calling Parent static variable from Parent reference after converting 
            Child reference to Parent reference
        */
        // System.out.println(((Parent)c).j);
        
        /* 
            calling Parent instance variable from Child reference after converting 
            Child reference to Parent reference and then from Parent reference back
            to Child reference
        */
        System.out.println(((Child)((Parent)c)).i);
        
        /* 
            calling Parent static variable from Child reference after converting 
            Child reference to Parent reference and then from Parent reference back
            to Child reference
        */
        // System.out.println(((Child)((Parent)c)).j);
        
        /* 
            calling Child instance variable from Child reference after converting 
            Child reference to Parent reference and then from Parent reference back
            to Child reference
        */
        System.out.println(((Child)((Parent)c)).x);
        
        /* 
            calling Child static variable from Child reference after converting 
            Child reference to Parent reference and then from Parent reference back
            to Child reference
        */
        // System.out.println(((Child)((Parent)c)).y);
        
    }
}
