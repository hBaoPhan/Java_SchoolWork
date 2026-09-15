import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class SumRangeParallel extends RecursiveTask<Long>{
    private final long start; //0
    private final long end;//10000
    private final long threshold;//1000

    public SumRangeParallel(long start, long end, long threshold) {
        this.start = start;
        this.end = end;
        this.threshold = threshold;
    }

    @Override
    protected Long compute() {
        if(end-start<threshold){
            long total=0l;
            for (long i = start; i < end; i++) {
                total+=i;
            }
            return total;
        }
        long mid=(start+end)/2;
        SumRangeParallel leftTask=new SumRangeParallel(start, mid, threshold);
        SumRangeParallel rightTask=new SumRangeParallel(mid, end, threshold);

        leftTask.fork(); //queue
        long rightResult= rightTask.compute();
        long leftResult=leftTask.join();
        return  leftResult+rightResult;

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool pool=new ForkJoinPool();
        SumRangeParallel task=new SumRangeParallel(0,10,5);
        ForkJoinTask<Long> submit=pool.submit(task);
        long result=submit.get();
        System.out.println(result);
        pool.shutdown();


    }
}
