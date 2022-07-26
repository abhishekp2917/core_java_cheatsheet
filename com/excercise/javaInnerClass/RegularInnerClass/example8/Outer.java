package com.excercise.javaInnerClass.RegularInnerClass.example8;

/* 
    inner class inside inner class 
*/

// outer class
public class Outer {

    // outer class instance variable
    String s = "Outer class";

    // outer class instance method
    void outerMethod() {
        
        // local variable
        String s = "Outer class local";

        // creating Inner class object
        Inner i = new Inner();

        // calling Inner class instance method
        i.innerMethod();

        // accessing local variable
        System.out.println("From outer class : " + s);
        // accessing outer class instance variable 
        System.out.println("From outer class : " + this.s);
    }

    // inner class
    class Inner {

        // inner class instance variable
        String s = "Inner class";

        // inner class instance method
        void innerMethod() {

            // local variable
            String s = "Inner class local";

            // creating InsideInner class object
            InsideInner ii = new InsideInner();

            // calling InsideInner class instance method
            ii.insideInnerMethod();
            
            // accessing local variable
            System.out.println("From inner class : " + s);
            // accessing inner class instance variable 
            System.out.println("From inner class : " + this.s);
            // accessing outer class instance variable 
            System.out.println("From inner class : " + Outer.this.s);
        }

        // InsideInner class
        class InsideInner {

            // InsideInner class instance variable
            String s = "Inside Inner class";

            // InsideInner class instance method
            void insideInnerMethod() {

                // local variable
                String s = "Inside inner class local";

                // accessing local variable
                System.out.println("From inside inner class : " + s);
                // accessing Insideinner class instance variable
                System.out.println("From inside inner class : " + this.s);
                // accessing inner class instance variable
                System.out.println("From inside inner class : " + Inner.this.s);
                // accessing outer class instance variable
                System.out.println("From inside inner class : " + Outer.this.s);
            }
        } 
    
    }

    public static void main(String[] args) {
        
        // creating outer class object
        Outer o = new Outer();

        // creating inner class object using outer class object
        Outer.Inner i = o.new Inner();

        // creating InsideInner class object using inner class object
        Outer.Inner.InsideInner ii = i.new InsideInner();

        // calling outer class instance method
        o.outerMethod();

        // calling inner class instance method
        i.innerMethod();

        // calling InsideInner class instance method
        ii.insideInnerMethod();
    }
}
