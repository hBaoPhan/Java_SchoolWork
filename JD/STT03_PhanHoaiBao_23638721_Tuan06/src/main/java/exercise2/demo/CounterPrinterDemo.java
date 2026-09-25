package exercise2.demo;

import exercise2.thread.Counter;
import exercise2.thread.Printer;
import exercise2.thread.Storage;

/**
 * Demo for Exercise 2 - Item 4: Storage, Counter and Printer.
 * Demonstrates wait-notify synchronization ensuring each number is printed exactly once.
 */
public class CounterPrinterDemo {
    public static void main(String[] args) {
        System.out.println("=== Starting Storage - Counter - Printer Demo ===");
        Storage storage = new Storage();
        int totalNumbers = 10; // count from 0 to 10

        Thread counterThread = new Thread(new Counter(storage, totalNumbers), "Counter-Thread");
        Thread printerThread = new Thread(new Printer(storage, totalNumbers), "Printer-Thread");

        counterThread.start();
        printerThread.start();

        try {
            counterThread.join();
            printerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("=== Demo Completed Successfully ===");
    }
}
