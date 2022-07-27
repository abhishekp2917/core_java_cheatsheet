package com.excercise.javaInnerClass.AnnonymousInnerClass.example4;

// defining thread by extending Thread class through normal class approach  

// defining MyThread that extends Thread class
class MyThread extends Thread {

    // overriding run method of Thread class
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
        
        // creating MyThread object
        MyThread t = new MyThread();

        // running child thread
        t.run();

        // definig job that this main thread would perform
        for(int i=0; i<10; i++) {

            System.out.println("Running main thread");
        }
    }
}
