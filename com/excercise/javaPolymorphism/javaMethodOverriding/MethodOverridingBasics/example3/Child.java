package com.excercise.javaPolymorphism.javaMethodOverriding.MethodOverridingBasics.example3;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Child extends Parent {
    
    /* 
        overriden method throws Checked Exception (Exception)
        overriding method doesn't throw any Exception
    */
    @Override
    public void method1() {
        System.out.println("Child method1");
    }

    /* 
        overriden method throws Checked Exception (IOException)
        overriding method throws same Checked Exception
    */
    @Override
    public void method2() throws IOException {
        System.out.println("Child method2");
    }

    /* 
        overriden method throws Checked Exception (IOException)
        overriding method throws child of overriden thrown Checked Exception (FileNotFoundException, EOFException)
    */
    @Override
    public void method3() throws FileNotFoundException, EOFException {
        System.out.println("Child method3");
    }

    /* 
        overriden method throws Checked Exception (IOException)
        overriding method throws Unchecked Exception (ArithmeticException, NullPointerException, Error)
    */
    @Override
    public void method4() throws ArithmeticException, NullPointerException, Error {
        System.out.println("Child method4");
    }

    /* 
        overriden method doesn't throw any Exception
        overriding method throws Unchecked Exception (ArithmeticException)
    */
    @Override
    public void method5() throws ArithmeticException {
        System.out.println("Child method5");
    }

    /* 
        overriden method throws Unchecked Exception (ArithmeticException)
        overriding method throws other Unchecked Exception (NullPointerException)
    */
    @Override
    public void method6() throws NullPointerException {
        System.out.println("Child method5");
    }
}
