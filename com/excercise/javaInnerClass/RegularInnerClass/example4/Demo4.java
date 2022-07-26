package com.excercise.javaInnerClass.RegularInnerClass.example4;

// accessing inner class instance members from outside of outer class

// creating outer class
class Outer {

    // creating inner class
    class Inner {

        // inner class instance variables
        int a;
        int b;

        // inner class constructor
        Inner(int a, int b) {
            this.a = a;
            this.b = b;
        }

        // inner class instance method
        public void add() {
            System.out.println(this.a + this.b);
        }
    }
}

public class Demo4 {

    public static void main(String[] args) {
        
        // creating outer class object so that we can create inner class object
        Outer o = new Outer();

        // creating inner class object using outer class object
        Outer.Inner i = o.new Inner(30, 40);

        // calling inner class instance method
        i.add();
    }
}