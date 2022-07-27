package com.excercise.javaInnerClass.AnnonymousInnerClass.example7;

// defining thread by implementing Runnable interface through annonymous inner class approach  

public class Test {

    public static void main(String[] args) {

        // creating target runnable by creating annonymous inner class that implements Runnable interface
        Runnable r = new Runnable() {

            // overriding run method of Runnable interface
            @Override
            public void run() {
        
                // defining job that this thread would perform
                for(int i=0; i<10; i++) {
        
                    System.out.println("Running child thread");
                }
            }
        };

        // creating Thread object that runs target runnable
        Thread t = new Thread(r);

        // running child thread
        t.run();

        // definig job that this main thread would perform
        for(int i=0; i<10; i++) {

            System.out.println("Running main thread");
        }
    }
}