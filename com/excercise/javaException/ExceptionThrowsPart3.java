package com.excercise.javaException;

import java.io.IOException;

public class ExceptionThrowsPart3 {
    
    public static void main(String[] args) {
        
        try{

            /* 
                method1 throws InterruptedException (Checked Exception), IOException 
                (Checked Exception) and ArithmeticException  (Unchecked Exception)
            */
            method1();
        }
        /*
            handling InterruptedException (Checked Exception) and  IOException 
            (Checked Exception)

            here there is no need to handle ArithmeticException as it is Unchecked 
            Exception
        */
        catch(InterruptedException | IOException e) {
            System.out.println(e.getMessage());
        }
    }



    /* 
        delegating multiple exception to caller method and caller method must handle 
        all of the Checked exceptions

        delegating InterruptedException (Checked Exception), IOException 
        (Checked Exception) and ArithmeticException  (Unchecked Exception) handling 
        responsibilty to caller method
    */
    public static void method1() throws InterruptedException, IOException, ArithmeticException {

        // this will create InterruptedException object which is a Checked Exception
        // which must be handled either by using 'throws' or try-catch block
        throw new InterruptedException();
    }
}
