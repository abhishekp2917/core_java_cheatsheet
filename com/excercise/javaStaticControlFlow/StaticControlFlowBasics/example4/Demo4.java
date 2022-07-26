package com.excercise.javaStaticControlFlow.StaticControlFlowBasics.example4;

public class Demo4 {
    
    // static block
    static {

        /* 
            we can't declare static members inside static member

            but surely we can declare instance members here
        */

        int j = 10;

        System.out.println(j);
    }

    // instance block
    {
        /* 
            we can't declare static members inside instance member

            but surely we can declare instance members here
        */

        int j = 10;

        System.out.println(j);
    }

    public static void main(String[] args) {
        
    }
}
