import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DemoThread6 {
    public static void main(String[] args) {
        long a=0L;
        long b=450L;

        Callable<Long> task1=new SumRangeTask(0, 50);
        Callable<Long> task2=new SumRangeTask(51, 100);
        Callable<Long> task3=new SumRangeTask(101,150);
        Callable<Long> task4=new SumRangeTask(151,300);
        Callable<Long> task5=new SumRangeTask(301,450);

        ExecutorService pool= Executors.newFixedThreadPool(3);
//        ExecutorService pool= Executors.newCachedThreadPool();
        pool.submit(task1);
        pool.submit(task2);
        pool.submit(task3);
        pool.submit(task4);
        pool.submit(task5);
        pool.shutdown(); // Làm xong pool mới shutdown
//        pool.shutdownNow(); // Liền luôn
    }
}
