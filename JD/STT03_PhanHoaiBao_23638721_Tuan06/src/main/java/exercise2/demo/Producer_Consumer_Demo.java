package exercise2.demo;

/**
 * Exercise 2 - Item 4a: Wrong Solution for Producer-Consumer problem.
 * Explanation:
 * Without wait() and notify(), the synchronization only prevents simultaneous
 * execution of put() and get(). However, there is no communication/coordination
 * between the producer and consumer. As a result:
 * - Producer can put multiple items and overwrite values before the consumer reads them (lost data).
 * - Consumer can read the same value multiple times before producer puts a new one (duplicated reads).
 */
public class Producer_Consumer_Demo {

    static class MyQueue {
        int n;

        synchronized int get() {
            System.out.println("Got: " + n);
            return n;
        }

        synchronized void put(int n) {
            this.n = n;
            System.out.println("Put: " + n);
        }
    }

    static class Producer implements Runnable {
        MyQueue q;

        Producer(MyQueue q) {
            this.q = q;
            new Thread(this, "Producer").start();
        }

        public void run() {
            int i = 0;
            // Run for 15 iterations to demonstrate in console without infinite loop
            while (i < 15) {
                q.put(i++);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ignored) {}
            }
        }
    }

    static class Consumer implements Runnable {
        MyQueue q;

        Consumer(MyQueue q) {
            this.q = q;
            new Thread(this, "Consumer").start();
        }

        public void run() {
            int count = 0;
            while (count < 15) {
                q.get();
                count++;
                try {
                    Thread.sleep(150);
                } catch (InterruptedException ignored) {}
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Running Producer_Consumer_Demo (Wrong Solution) ===");
        MyQueue q = new MyQueue();
        new Producer(q);
        new Consumer(q);
    }
}
