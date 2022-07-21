package com.excercise.javaException;

public class ExceptionUnchecked {
    
    public static void main(String[] args){

        int a = 10, b = 0;

        // statement that can raise Unchecked Exception
        float c = a/b;

        System.out.println("Division of a="+a+" by b="+b+" is "+c);
    }
}
