package com.excercise.javaException;

public class ExceptionErrorPart1 {
    
    public static void main(String[] args) {

        // handling Error using try catch block
        try{
            // manually b throwing StackOverflowError 
            throw new StackOverflowError();
        }
        // handling StackOverflowError
        catch(StackOverflowError e) {

            System.out.println("manual StackOverflowError occured");
        }


        // handling Error using try catch block
        try{
            
            // calling this method will create stackoverflow because of infinite recursive calls 
            m1();
        }
        // handling StackOverflowError
        catch(StackOverflowError e) {

            System.out.println("StackOverflowError occured");
        }
    }

    // method m1() calling method m2()
    private static void m1() {

        m2();
    }

    // method m2() calling method m1()
    private static void m2() {
        
        m1();
    }
}
