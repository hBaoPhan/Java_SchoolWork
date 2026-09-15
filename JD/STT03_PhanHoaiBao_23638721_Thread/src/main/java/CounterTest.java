import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CounterTest {
    private static Counter counter=new Counter();

    public static void main(String[] args) {
        Runnable task =()->{
            counter.increase();
        };
        ExecutorService pool= Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            pool.submit(task);
        }

        pool.shutdown();
        while (!pool.isTerminated()){}
        System.out.println(counter.getCount());
    }
}
