package com.excercise.javaException;

public class ExceptionBasics {
    
    // since main method also doesn't have Exception handling code
    // JVM will terminate the main method abnormally
    // JVM will handover the Exception handling task to 'Default Exception Handler'
    public static void main(String[] args){

        System.out.println("Main method started");
        // this method will raise Exception
        method1();
        System.out.println("Main method ended");
    }

    // JVM will terminate this method abnormally since there is no code to handle Exception 
    // raise by 'method2()' and control of programe will be given to caller method (main())
    public static void method1(){
        System.out.println("Method-1 started");
        // this method will raise Exception
        method2();
        System.out.println("Method-1 ended");
    }

    // JVM will terminate this method abnormally after executing 'method3()'
    // since the Exception handling code is not present 
    // control of programe will be given to caller method (method1())
    public static void method2(){
        System.out.println("Method-2 started");
        method3();
        // Exception raising statement
        System.out.println(1/0);
        System.out.println("Method-2 ended");
    }

    // JVM will terminate this method normally by executing entire code
    public static void method3(){
        System.out.println("Method-3 started");
        System.out.println("Method-3 ended");
    }
} 
