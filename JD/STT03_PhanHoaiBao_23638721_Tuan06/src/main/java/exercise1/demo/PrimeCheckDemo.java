package exercise1.demo;

import exercise1.thread.PrimeCheckTask;

import java.util.concurrent.FutureTask;

public class PrimeCheckDemo {
    public static void main(String[] args) throws Exception {
        long x1 = 29;
        long x2 = 49;

        FutureTask<Boolean> task1 = new FutureTask<>(new PrimeCheckTask(x1));
        FutureTask<Boolean> task2 = new FutureTask<>(new PrimeCheckTask(x2));

        new Thread(task1).start();
        new Thread(task2).start();

        System.out.println(x1 + " là số nguyên tố? " + task1.get());
        System.out.println(x2 + " là số nguyên tố? " + task2.get());
    }
}