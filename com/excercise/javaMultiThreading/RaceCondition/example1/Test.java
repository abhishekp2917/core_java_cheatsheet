// A simple Counter class that is *not* thread-safe
class Counter {
    private int count = 0;

    // This method increments the count
    public void increment() {
        count++;  // Not thread-safe: count++ is not an atomic operation
    }

    public int getCount() {
        return count;
    }
}

public class Test {
    public static void main(String[] args) {
        Counter counter = new Counter();

        // 🔹 Thread 1 increments the counter 10000 times
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        });

        // 🔹 Thread 2 increments the counter 10000 times
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        });

        // Start both threads
        t1.start();
        t2.start();

        // Wait for both threads to finish execution
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Expected result is 20000 (10000 from each thread)
        // But due to race condition, actual result will often be less
        System.out.println("Final Counter Value: " + counter.getCount());
    }
}
