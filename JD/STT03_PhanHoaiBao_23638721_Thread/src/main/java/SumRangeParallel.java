import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class SumRangeParallel extends RecursiveTask<Long>{
    private final long start; //0
    private final long end;//10000
    private final long threshold;//1000
    private final int level;

    public SumRangeParallel(long start, long end, long threshold, int level) {
        this.start = start;
        this.end = end;
        this.threshold = threshold;
        this.level = level;
    }

    @Override
    protected Long compute() {
        String repeat=" ".repeat(level);
        String threadName=Thread.currentThread().getName();
        System.out.printf("%s%s: [%s, %s)%n",repeat,threadName,start,end);

        if(end-start<threshold){
            long total=0l;
            for (long i = start; i < end; i++) {
                total+=i;
            }
            return total;
        }
        long mid=(start+end)/2;
        SumRangeParallel leftTask=new SumRangeParallel(start, mid, threshold,level+1);
        SumRangeParallel rightTask=new SumRangeParallel(mid, end, threshold,level+1);

        leftTask.fork(); //queue
        long rightResult= rightTask.compute();
        long leftResult=leftTask.join();
        return  leftResult+rightResult;

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool pool=new ForkJoinPool();
        SumRangeParallel task=new SumRangeParallel(0,100,5,0);
        ForkJoinTask<Long> submit=pool.submit(task);
        long result=submit.get();
        System.out.println(result);
        pool.shutdown();
    }
}
