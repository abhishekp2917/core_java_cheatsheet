package com.excercise.javaMultiThreading.ThreadManagement.sleep.example1;


public class Test {
    public static void main(String[] args) {
        // This message is printed before the thread is paused.
        System.out.println("Task started...");
        
        try {
            // -------------------- Thread.sleep(3000) --------------------
            // The sleep() method is used to pause the execution of the current thread.
            // In this case, the main thread is paused for 3000 milliseconds (i.e., 3 seconds
            //
            // - It is a static method of the java.lang.Thread class.
            // - During this sleep time, the thread remains in TIMED_WAITING state.
            // - It does NOT release any locks if the thread holds any.
            // - After the specified time, the thread resumes execution.
            //
            // This method throws InterruptedException if:
            // - Another thread interrupts the sleeping thread before the time expires.
            Thread.sleep(3000);  // Pauses execution for 3 seconds (3000 milliseconds)
        } catch (InterruptedException e) {
            // This block handles the case where the sleep is interrupted.
            // It's good practice to either log it or restore the interrupted status.
            e.printStackTrace();
        }

        // This message is printed after the sleep is over.
        System.out.println("Task completed after sleep.");
    }
}
