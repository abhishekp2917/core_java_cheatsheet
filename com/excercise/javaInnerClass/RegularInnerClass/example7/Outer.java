package com.excercise.javaInnerClass.RegularInnerClass.example7;

/* 
    accesing outer class instance members from inside inner class when there is 
    naming conflict among outer variable, inner variable and inner class local 
    variable
*/

// creating outer class
public class Outer {

    // outer class instance variables
    String s = "Outer";

    // creating inner class
    class Inner {

        // inner class instance variable with name similar to outer class instance variable
        String s = "Inner";

        // inner class instance method
        public void display() {

            String s = "Local";

            // accessing outer class instance variable
            System.out.println(Outer.this.s);

            // accessing inner class instance variable
            System.out.println(this.s);

            // accessing local variable
            System.out.println(s);
        }
    }

    public static void main(String[] args) {

        // creating inner class object using outer class object
        Outer.Inner i = new Outer().new Inner();

        // calling inner class instance method
        i.display();
    }
}