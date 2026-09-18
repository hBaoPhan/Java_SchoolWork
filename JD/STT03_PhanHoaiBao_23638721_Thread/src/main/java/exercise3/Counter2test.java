package exercise3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Counter2test {
    private static Counter2 counter2=new Counter2();

    public static void main(String[] args) {
        Runnable task =()->{
            counter2.increase();
        };

        ExecutorService pool= Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            pool.submit(task);
        }
        pool.shutdown();
        while (!pool.isTerminated()){}
        System.out.println(counter2.getCount());
    }
}
