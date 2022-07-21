package com.excercise.javaException;

public class ExceptionHandling {
    
    public static void main(String[] args){

        // _________________________________________________________________________________

        System.out.println("\n___________________Exception handling____________________\n");

        // this statement will get executed
        System.out.println("Statement 1 executed");

        // putting Exception raising code inside try block
        try{
            // Exception raising statement
            System.out.println(10/0);

            // rest of the code won't execute
            System.out.println("Statement 2 executed");
        }

        // ArithmeticException handling code
        catch(ArithmeticException exception){

            System.out.println("ArithmeticException handled");
        }

        // exectute remainig code after handling Exception
        System.out.println("Statement 3 executed\n");






        // ________________________________________________________________________________

        System.out.println("\n______________console Exception message ______________\n");

        // this statement will get executed
        System.out.println("Statement 1 executed");

        // putting Exception raising code inside try block
        try{
            // Exception raising statement
            System.out.println(10/0);

            // rest of the code won't execute
            System.out.println("Statement 2 executed");
        }

        // ArithmeticException handling code
        catch(ArithmeticException exception){

            // below statement will print Exception name and Exception description
            System.out.println("Exception name : Exception description");
            System.out.println(exception);
            System.out.println(exception.toString());

            // below statement will print only Exception description
            System.out.println("\nException description");
            System.out.println(exception.getMessage());

            // below statement will print entire Exception info including Exception location
            System.out.println("\nException full info");
            exception.printStackTrace();
        }

        // exectute remainig code after handling Exception
        System.out.println("Statement 3 executed\n");






        // ________________________________________________________________________________

        System.out.println("\n_____Exception handling with multiple catch block_____\n");

        // this statement will get executed
        System.out.println("Statement 1 executed");

        // putting Exception raising code inside try block
        try{
            int[] nums = {2, 3};

            // ArrayIndexOutOfBoundException raising statement
            System.out.println(nums[2]);

            // rest of the code won't execute
            System.out.println("Statement 2 executed");
        }

        // ArithmeticException handling code
        catch(ArithmeticException exception){

            System.out.println("ArithmeticException handled");
        }

        // ArithmeticException handling code
        catch(ArrayIndexOutOfBoundsException exception){

            System.out.println("ArrayIndexOutOfBoundsException handled");
        }

        // if above catch blocks can't handle raised Exception then below catch bolck will handle it
        // this block can handle any type of Exception
        catch(Exception exception){

            System.out.println("default Exception handled");
        }

        // exectute remaining code after handling Exception
        System.out.println("Statement 3 executed\n");





        // ________________________________________________________________________________

        System.out.println("\n_________Exception catch block wrong practice_________\n");

        // this statement will get executed
        System.out.println("Statement 1 executed");

        // putting Exception raising code inside try block
        try{
            int[] nums = {2, 3};

            // ArrayIndexOutOfBoundException raising statement
            System.out.println(nums[2]);

            // rest of the code won't execute
            System.out.println("Statement 2 executed");
        }

        // this block can handle any type of Exception
        // default Exception block should always be after any other Exception block
        // catch(Exception exception){

        //     System.out.println("default Exception handled");
        // }

        // ArithmeticException handling code
        catch(ArithmeticException exception){

            System.out.println("ArithmeticException handled");
        }

        // ArithmeticException handling code
        catch(ArrayIndexOutOfBoundsException exception){

            System.out.println("ArrayIndexOutOfBoundsException handled");
        }

        // Another ArithmeticException handling code will give complie time error
        // as this Exception has already been taken care off earlier
        // catch(ArrayIndexOutOfBoundsException exception){

        //     System.out.println("ArrayIndexOutOfBoundsException handled");
        // }


        // exectute remaining code after handling Exception
        System.out.println("Statement 3 executed\n");




        // ________________________________________________________________________________

        System.out.println("\n_______Exception handling with finally block_________\n");

        // this statement will get executed
        System.out.println("Statement 1 executed");

        // putting Exception raising code inside try block
        try{
            int[] nums = {2, 3};

            // ArrayIndexOutOfBoundException raising statement
            System.out.println(nums[2]);

            // rest of the code won't execute
            System.out.println("Statement 2 executed");
        }

        // ArithmeticException handling code
        catch(ArithmeticException exception){

            System.out.println("ArithmeticException handled");
        }

        // ArithmeticException handling code
        catch(ArrayIndexOutOfBoundsException exception){

            System.out.println("ArrayIndexOutOfBoundsException handled");
        }

        // if above catch blocks can't handle raised Exception then below catch bolck will handle it
        // this block can handle any type of Exception
        catch(Exception exception){

            System.out.println("default Exception handled");
        }

        // code in finally block will be executed irrespective of the result of try block
        // finally block must be after catch block and there should be only one finally block
        finally{
            System.out.println("finally block code executed");
        }

        // exectute remaining code after handling Exception
        System.out.println("Statement 3 executed\n");
    }
}
