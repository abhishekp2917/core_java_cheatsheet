package com.excercise.javaGarbageCollector;


class Test{

    static int id = 0;

    Test() {
        ++id;
    }

    public void finalize(){

        System.out.println("Calling Test class finalize method of Id : "+ id);
    }

    public void dummyMethod(){
    }
}

public class GCFinalize {

    public static void main(String[] args) {

        System.out.println("\n________checking if GC destroys objects implicitly________\n");
    
        for(int i=0; i<100000; ++i){
            // creating test object
            Test t = new Test();
            t.dummyMethod();

            // nullifying Test class reference variable 
            t = null;
        }



        // _____________________________________________________________________________________

        System.out.println("\n________checking if GC destroys objects explicitly________\n");

        for(int i=0; i<100; ++i){
            // creating test object
            Test t = new Test();
            t.dummyMethod();

            // nullifying Test class reference variable 
            t = null;
        }

        // requesting GC
        System.gc();



        // _____________________________________________________________________________________

        System.out.println("\n________calling Test object finalize method explicitly______\n");

        Test t = new Test();

        // calling finalize method which won't destroy object but act as a normal method
        t.finalize();

        System.out.println("Main method ends");
    }
    
}
