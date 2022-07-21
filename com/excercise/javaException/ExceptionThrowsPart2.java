package com.excercise.javaException;

public class ExceptionThrowsPart2 {
    
    public static void main(String[] args) {

        // since below methods have delegated Exception handling 
        // responsibility to caller methods, main method has to handle all these methods

        System.out.println("\n___________method that delegated handling responsibility________\n");

        // any Exception which has to be handled is only required to be in try block
        // while catch block can catch any Exception which could be or couldn't be of 
        // same Exception class 


        try{
            method1();
        }
        catch(InterruptedException e){
            System.out.println("Handling method1 which raises InterruptedException");
        }
        
        try{
            method2();
        }
        catch(Exception e){
            System.out.println("Handling method2 which raises Exception");
        }

        try{
            method4();
        }
        catch(Error e){
            System.out.println("Handling method4 which raises Error but delegated to handle Interrupted Exception");
        }
        catch(Exception e){
            System.out.println("Handle Exception if any");
        }

        System.out.println("\n___________method that didn't delegate handling responsibility________\n");

        // there is no need to handle method3 to convience compiler
        //  as it raises Unchecked Exception which won't be checked by compiler
        // but it will surely raise an Exception 
        method3();
    }










    // delegating InterruptedException (Checked Exception) handling responsibilty to caller method
    public static void method1() throws InterruptedException {

        // this will create InterruptedException object which is a Checked Exception
        // which must be handled either by using 'throws' or try-catch block
        throw new InterruptedException();
    }






    // delegating Exception (Partially Checked) handling responsibilty to caller method
    public static void method2() throws Exception {

        // this will create Exception object which is a Partially Checked Exception
        // if there is even a single chance of raising Checked Exception  
        // it must be handled either by using 'throws' or try-catch block
        throw new Exception();
    }






    // it is not mandatory to delegate Error (Unchecked Exception)
    public static void method3() {
         
        // this will create Error object which is an Unchecked Exception
        // it is not mandatory to handle Error (Unchecked Exception)
        throw new Error();
    }






    // one can delegate Error (Unchecked Exception) handling responsibilty to caller method
    // but it is not recommended
    public static void method4() throws InterruptedException {
         
        // this will create Error object which is an Unchecked Exception
        // it is not mandatory to handle Error (Unchecked Exception)
        throw new Error();   
    }
}
