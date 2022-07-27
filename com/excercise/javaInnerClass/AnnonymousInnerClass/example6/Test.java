package com.excercise.javaInnerClass.AnnonymousInnerClass.example6;

// defining thread by implementing Runnable interface through normal class approach  


// defining MyThread that implements Runnable interface
class MyThread implements Runnable {

    // overriding run method of Runnable interface
    @Override
    public void run() {

        // defining job that this thread would perform
        for(int i=0; i<10; i++) {

            System.out.println("Running child thread");
        }
    }
}

public class Test {

    public static void main(String[] args) {
        
        // creating MyThread object (target runnable)
        MyThread r = new MyThread();

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