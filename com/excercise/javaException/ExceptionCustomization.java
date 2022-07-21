package com.excercise.javaException;

import java.util.Scanner;

// creating custom exception by extending RuntimeException (Unchecked Exception)
class UnderAgeException extends RuntimeException{

    // constuctor to call parent method constructor to set exception description
    // so that default exception handler can use the description
    UnderAgeException(String exceptionDescription){
        super(exceptionDescription);
    }
}

// creating custom exception by extending RuntimeException (Unchecked Exception)
class OverAgeException extends RuntimeException{
    
    // constuctor to call parent method constructor to set exception description
    // so that default exception handler can use the description
    OverAgeException(String exceptionDescription){
        super(exceptionDescription);
    }
}

// creating custom exception by extending Exception (partially Checked Exception)
// such type of creation of cutom exception is not recommended
class InsufficientBalanceException extends Exception{

    // constuctor to call parent method constructor to set exception description
    // so that default exception handler can use the description
    InsufficientBalanceException(String exceptionDescription){
        super(exceptionDescription);
    }
}

public class ExceptionCustomization {

    // delegating responsibility to handle InsufficientBalanceException to JVM 
    public static void main(String[] args) throws InsufficientBalanceException {

        System.out.println("Enter your age : ");

        Scanner sc = new Scanner(System.in);

        // getting user input
        int age = sc.nextInt();
        int balance = 2000;
        int amount = sc.nextInt();

        sc.close();

        if(age<18){
            // throwing UnderAgeException
            throw new UnderAgeException("You are underaged");
        }
        else if(age>40){
            // throwing OverAgeException
            throw new OverAgeException("You are Overaged");
        }
        else{
            System.out.println("Your entered age is "+age);
        }



        if(amount>balance){
            // throwing InsufficientBalanceException which must be handled as it is a
            // child of Checked Exception
            throw new InsufficientBalanceException("Insufficient balance");
        }
        else{
            balance -= amount;
            System.out.println("Your current balance is "+balance);
        }
    }
}
