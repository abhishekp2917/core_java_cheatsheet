// Main class to run the program
public class Main {
    public static void main(String[] args) {

        // Create an instance of the custom thread
        MyDaemonThread daemonThread = new MyDaemonThread();

        // Set the thread as a daemon thread BEFORE starting it
        // Daemon threads are background threads that do not prevent JVM shutdown.
        // JVM will exit when all **non-daemon** (main/user) threads finish.
        daemonThread.setDaemon(true);

        // Start the daemon thread
        daemonThread.start();

        System.out.println("Main thread is running...");

        try {
            // Main thread sleeps for few seconds
            // During this time, the daemon thread will keep running in the background
            Thread.sleep(9000);
        } catch (InterruptedException e) {}

        // After few seconds, the main thread finishes
        System.out.println("Main thread finished execution");

        // JVM automatically terminates the daemon thread here
        // Since no non-daemon threads are alive anymore, the JVM exits
        // and does NOT wait for the infinite daemon thread to finish.
    }
}

// Custom thread class extending Thread
class MyDaemonThread extends Thread {

    // The code that runs when the thread starts
    public void run() {

        // Infinite loop to simulate continuous background task
        while (true) {
            System.out.println("Daemon thread is running...");

            try {
                // Sleep for 1 second to simulate periodic task
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

