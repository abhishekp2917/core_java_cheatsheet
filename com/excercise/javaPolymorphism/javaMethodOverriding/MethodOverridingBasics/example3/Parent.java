package com.excercise.javaPolymorphism.javaMethodOverriding.MethodOverridingBasics.example3;

import java.io.IOException;

public class Parent {

    public void method1() throws Exception {
        System.out.println("Parent method1");
    }

    public void method2() throws IOException {
        System.out.println("Parent method2");
    }

    public void method3() throws IOException {
        System.out.println("Parent method3");
    }

    public void method4() throws IOException {
        System.out.println("Parent method4");
    }

    public void method5() {
        System.out.println("Parent method5");
    }

    public void method6() throws ArithmeticException {
        System.out.println("Parent method5");
    }
}
