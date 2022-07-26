package com.excercise.javaInnerClass.RegularInnerClass.example3;

// accessing inner class instance members from outer class instance area 

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

    // outer class instance method
    public void outerMethod() {

        // creating inner class object
        Inner i1 = new Inner(30, 30);

        // calling inner class method
        i1.add();

        // creating outer class object
        Outer o = new Outer();

        // creating inner class object using outer class object
        Outer.Inner i2 = o.new Inner(50, 50);

        // calling inner class object
        i2.add();
    }

    public static void main(String[] args) {
        
        // creating outer class object 
        Outer o = new Outer();

        // calling outer class instance method
        o.outerMethod();
    }
}
