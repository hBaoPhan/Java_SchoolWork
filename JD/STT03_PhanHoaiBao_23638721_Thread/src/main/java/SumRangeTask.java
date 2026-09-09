import java.util.concurrent.Callable;

class SumRangeTask implements Callable<Long> {
    private long a;
    private long b;

    public SumRangeTask(long a, long b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public Long call() throws Exception {

        System.out.println(Thread.currentThread().getName());
        long total=0L;
        for (long i = a; i < b; i++) {
            total+=i;
        }
        return total;
    }
}