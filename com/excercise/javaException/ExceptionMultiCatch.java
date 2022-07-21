package com.excercise.javaException;

import java.util.Scanner;

public class ExceptionMultiCatch {
    
    public static void main(String[] args){

        try(Scanner sc = new Scanner(System.in);){

            // statement that might raise NumberFormatException
            int a = Integer.parseInt(sc.nextLine());
            int b = Integer.parseInt(sc.nextLine());

            // statement that might raise ArithmeticException
            int c = a/b;
            System.out.println("Division of "+a+" by "+b+" is "+c);
        }

        // handling ArithmeticException and NumberFormatException and providing same handling code for both
        catch(ArithmeticException | NumberFormatException e){
            System.out.println(e.toString());
        } 

        // handling StringIndexOutOfBoundsException and ArrayIndexOutOfBoundsException and providing same handling code for both
        catch(StringIndexOutOfBoundsException | ArrayIndexOutOfBoundsException e){
            e.getStackTrace();
        }
    }
}
