package com.excercise.javaInnerClass.AnnonymousInnerClass.example8;

// defining annonymous inner class inside thread object runnable argument

public class Test {

    public static void main(String[] args) {

        /*
            defining annonymous inner class that defined inside Thread object's
            runnable argument
        */
        Thread t = new Thread(new Runnable() {

            // overriding run method of Runnable interface
            @Override
            public void run() {
        
                // defining job that this thread would perform
                for(int i=0; i<10; i++) {
        
                    System.out.println("Running child thread");
                }
            }
        });

        // running child thread
        t.run();

        // definig job that this main thread would perform
        for(int i=0; i<10; i++) {

            System.out.println("Running main thread");
        }
    }
}
