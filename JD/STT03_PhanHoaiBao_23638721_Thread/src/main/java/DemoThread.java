public class DemoThread {
    public static void main(String[] args) {
        MyTask myTask=new MyTask(0,10);
         myTask.start(); // Tạo thread
//         myTask.run(); // chạy bằng main
    }

}

class MyTask extends Thread{
    private long a;
    private long b;

    public MyTask(long a, long b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        long total=0L;
        for (long i = a; i <= b; i++) {
            total+=i;
        }
        System.out.println(Thread.currentThread().getName()+", Total: "+total);
    }
}
