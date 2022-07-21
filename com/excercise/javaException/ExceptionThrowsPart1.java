package com.excercise.javaException;

public class ExceptionThrowsPart1 {

    // delegating InterruptedException handling responsibility to JVM 
    // JVM will delegate this responsibility to 'default exception handler'
    public static void main(String[] args) throws InterruptedException {
        
        // this method has delegated InterruptedException handling responsibility to caller method
        // this must be handle using 'throws' or by using try-catch block
        method1();
    }

    // delegating InterruptedException handling responsibility to caller method
    public static void method1() throws InterruptedException {

        // this method has delegated InterruptedException handling responsibility to caller method
        // this must be handle using 'throws' or by using try-catch block
        method2();
    }

    // delegating InterruptedException handling responsibility to caller method
    public static void method2() throws InterruptedException {

        // this method has delegated InterruptedException handling responsibility to caller method
        // this must be handle using 'throws' or by using try-catch block
        method3();
    }

    // delegating InterruptedException handling responsibility to caller method
    public static void method3() throws InterruptedException {

        // this will rise Checked Exception
        // this must be handle using 'throws' or by using try-catch block
        Thread.sleep(1000);
    }
}
