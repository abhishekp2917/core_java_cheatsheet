package com.excercise.javaPolymorphism.javaVariableHiding.VariableHidingBasics.example1;

public class Demo1 {
    
    public static void main(String[] args) {
        
        // creating Parent object with Parent reference
        Parent p1 = new Parent();

        // creating Child object with Child reference
        Child c1 = new Child();

        // creating Child object with Parent reference
        Parent p2 = new Child();

        /* 
            since parent reference is used, that's why parent variable s1 and 
            parent static variable s2 will be invoked 
        */
        System.out.println(p1.s1);
        // System.out.println(p1.s2);

        /* 
            since child reference is used, that's why child variable s1 and 
            child static variable s2 will be invoked 
        */        
        System.out.println(c1.s1);
        // System.out.println(c1.s2);

        /* 
            since parent reference is used, that's why even though runtime object
            is of child type parent variable s1 and parent static variable s2 will be 
            invoked 
        */
        System.out.println(p2.s1);
        // System.out.println(p2.s2);

    }
}
