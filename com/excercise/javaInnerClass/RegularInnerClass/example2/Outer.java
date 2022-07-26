package com.excercise.javaInnerClass.RegularInnerClass.example2;

// accessing inner class instance members from outer class static area 

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

    public static void main(String[] args) {
        
        // creating outer class object so that we can create inner class object
        Outer o = new Outer();

        // creating inner class object using outer class object
        Outer.Inner i = o.new Inner(10, 20);

        // calling inner class object
        i.add();

        // creating outer and inner class object and calling inner class method in single line
        new Outer().new Inner(20, 30).add();
    }
}
