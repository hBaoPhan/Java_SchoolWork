public class DemoThread3 {
    public static void main(String[] args) throws InterruptedException {
        Runnable task =new Task();
        Thread thread=new Thread(task);
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
        Thread.sleep(200);
        System.out.println(thread.getState());
//        while (thread.isAlive()){}
        thread.join();
        thread.yield();
        System.out.println(thread.getState());

    }
}

class Task implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
