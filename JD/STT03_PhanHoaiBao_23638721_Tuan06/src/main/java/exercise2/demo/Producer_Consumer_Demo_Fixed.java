package exercise2.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Exercise 2 - Item 4b: Correct Solution for Producer-Consumer problem using wait() and notify().
 * Explanation:
 * - Uses a boolean flag `valueSet` and wait()/notify() mechanism.
 * - put() waits if valueSet == true, sets the value, sets valueSet = true, and calls notify().
 * - get() waits if valueSet == false, reads the value, sets valueSet = false, and calls notify().
 * - This guarantees strictly alternating execution: Put -> Got -> Put -> Got...
 * - No data loss and no duplicate reading.
 */
public class Producer_Consumer_Demo_Fixed {

    static class MyQueue {
        int n;
        boolean valueSet = false;

        synchronized int get() {
            while (!valueSet) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return -1;
                }
            }
            System.out.println("Got: " + n);
            try {
                Thread.sleep(300);
            } catch (Exception x) {
                Thread.currentThread().interrupt();
            }
            valueSet = false;
            notify();
            return n;
        }

        synchronized void put(int n) {
            while (valueSet) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            this.n = n;
            valueSet = true;
            System.out.println("Put: " + n);
            try {
                Thread.sleep(500);
            } catch (Exception x) {
                Thread.currentThread().interrupt();
            }
            notify();
        }
    }

    static class Producer implements Runnable {
        MyQueue q;

        Producer(MyQueue q) {
            this.q = q;
        }

        public void run() {
            int i = 0;
            while (i < 10) {
                q.put(i++);
            }
        }
    }

    static class Consumer implements Runnable {
        MyQueue q;

        Consumer(MyQueue q) {
            this.q = q;
        }

        public void run() {
            int count = 0;
            while (count < 10) {
                q.get();
                count++;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Running Producer_Consumer_Demo_Fixed (Correct Solution) ===");
        System.out.println("Press Control-C to stop.");
        ExecutorService service = Executors.newFixedThreadPool(2);
        MyQueue q = new MyQueue();
        service.execute(new Producer(q));
        service.execute(new Consumer(q));

        service.shutdown();
        try {
            if (service.awaitTermination(15, TimeUnit.SECONDS)) {
                System.out.println("=== Demo finished normally ===");
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
        }
    }
}
