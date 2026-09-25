package exercise1.demo;

import exercise1.thread.PrintNumbersTask;

public class PrintDemo {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new PrintNumbersTask("Task 1"));
        Thread thread2 = new Thread(new PrintNumbersTask("Task 2"));

        thread1.start();
        thread2.start();
    }
}