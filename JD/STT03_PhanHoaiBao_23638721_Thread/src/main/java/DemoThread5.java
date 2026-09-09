import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class DemoThread5 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long a=10L;
        long b=120L;
        System.out.println(Runtime.getRuntime().availableProcessors());
        int subTask=4;

//        range = (b-a+1)=120 - 10 + 1=111
//        subRange=range/subTask;
//        sybStart=a+i*subRange
//        subEnd=subStart+subRange-1
        Callable<Long> task1=new SumRangeTask(10,36);
        Callable<Long> task2=new SumRangeTask(37,63);
        Callable<Long> task3=new SumRangeTask(64,90);
        Callable<Long> task4=new SumRangeTask(91,120);

        Future<Long> fu1=new FutureTask<Long>(task1);
        Future<Long> fu2=new FutureTask<Long>(task2);
        Future<Long> fu3=new FutureTask<Long>(task3);
        Future<Long> fu4=new FutureTask<Long>(task4);

        new Thread((Runnable) fu1).start();
        new Thread((Runnable) fu2).start();
        new Thread((Runnable) fu3).start();
        new Thread((Runnable) fu4).start();

        long total= fu1.get()+ fu2.get()+fu3.get()+fu4.get();
        System.out.println("Finished, total is "+total);


    }
}


