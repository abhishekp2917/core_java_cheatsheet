package com.excercise.javaInnerClass.AnnonymousInnerClass.example5;

// defining thread by extending Thread class through annonymous inner class approach  


public class Test {

    public static void main(String[] args) {
        
        // creating thread by creating annonymous inner class that extends Thread class
        Thread t = new Thread() {

            // overriding run method of Thread class
            @Override
            public void run() {
        
                // defining job that this thread would perform
                for(int i=0; i<10; i++) {
        
                    System.out.println("Running child thread");
                }
            }
        };

        // running child thread
        t.run();

        // definig job that this main thread would perform
        for(int i=0; i<10; i++) {

            System.out.println("Running main thread");
        }
    }
}
