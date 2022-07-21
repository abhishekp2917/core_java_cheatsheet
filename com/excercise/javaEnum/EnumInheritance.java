package com.excercise.javaEnum;


// creating interface named 'A'
interface A{

    // interface properties
    public static final int VALUE1 = 10;

    // interface methods
    public abstract void printInteger(int value);
}

// creating interface named 'B'
interface B{

    // interface properties
    public static final boolean VALUE2 = true;

    // interface methods
    public abstract void printString(String value);
}

// enum can implement multiple interfaces but can't extend any class or enum
// enum friend implements interface A
enum Friend implements A, B{
    friend1,
    friend2,
    friend3;

    // overriding methods of interface 'A'
    public void printInteger(int value){
        System.out.println(value);
    }

    // overriding methods of interface 'B'
    public void printString(String value){
        System.out.println(value);
    }
}

public class EnumInheritance {
    public static void main(String[] args){

        Friend f1 = Friend.friend1;

        // printing enum value
        System.out.println(f1);

        // accessing method implemented by enum 'Friend' of interface 'A'
        f1.printInteger(12);
        
        // accessing method implemented by enum 'Friend' of interface 'B'
        f1.printString("Hello World");
    }
}
