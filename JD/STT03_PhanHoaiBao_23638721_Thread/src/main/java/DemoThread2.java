public class DemoThread2 {
    public static void main(String[] args) {
        Runnable task=new PrintCharTask("Trung tam tin hoc");
        Thread thread=new Thread(task,"Thread-One");
        thread.start();
    }
}

class PrintCharTask implements  Runnable{
    private String str;

    public PrintCharTask(String str) {
        this.str = str;
    }

    @Override
    public void run() {
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
        }
    }
}
