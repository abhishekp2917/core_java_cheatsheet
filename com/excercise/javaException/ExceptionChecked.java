package com.excercise.javaException;

public class ExceptionChecked{

    public static void main(String[] args){
        try{
            /*  
                method which can raise Checked Exception and has delegated caller 
                method (main() method in this case) to handle the Checked Exception
            */
            // handling Checked Exception using try catch block
            sleep(1000);
        }
        catch(InterruptedException e){

            System.out.println("Main thread interrupted");
        }
    }

    // delegated caller method to handle Checked Exception using 'throws' keyword
    public static void sleep(int milliseconds)  throws InterruptedException{

        // statement that must be handle which can raise Checked Exception
        Thread.sleep(milliseconds);
    }
}