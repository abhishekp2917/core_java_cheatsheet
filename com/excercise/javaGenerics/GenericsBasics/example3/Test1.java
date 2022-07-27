package com.excercise.javaGenerics.GenericsBasics.example3;

// defining own generic classes, interface, instance variables, methods and constructors

// defining generic interface with type paratmeter 'T'
interface MyInterface <T> {

    // generic method that takes paramter of type 'T'
    public void doSomething(T obj);
}


// defining generic class with type paratmeter 'T'
class MyClass <T> implements MyInterface <T> {

    // generic instance variable
    public T obj;

    // generic constructor 
    MyClass(T obj) {
        
        this.obj = obj;
    }

    // generic method that takes paramter of type 'T'
    public void setObj(T obj) {

        this.obj = obj;
    }

    // generic method that returns object of type 'T'
    public T getObj() {
        
        return obj;
    }

    // overriding MyInterface generic method 
    @Override
    public void doSomething(T obj) {

        System.out.println("Class : " + obj.getClass().getName());
    }
}

public class Test1 {
    
    public static void main(String[] args) {
        
        // creating MyClass object with String type parameter
        MyClass <String> c1 = new MyClass<String>("String object");

        // creating MyClass object with Integer type parameter
        MyClass <Integer> c2 = new MyClass<Integer>(10);

        // accessing MyClass object method 
        System.out.println(c1.getObj().getClass().getName());

        c1.doSomething(new String("Hello"));

        System.out.println(c2.getObj().getClass().getName());

        c2.doSomething(10);

    }
}
