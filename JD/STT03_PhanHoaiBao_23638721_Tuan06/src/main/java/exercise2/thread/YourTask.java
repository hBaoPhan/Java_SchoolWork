package exercise2.thread;

public class YourTask implements Runnable {

    @Override
    public void run() {
        try {
            Thread t = new Thread(
                    new AnotherTask("Another task", 10));
            t.start(); //start another task
            for (int i = 0; i < 8; i++) {
                System.out.println("Your Task #" + i);
                if (i == 5)
                    t.join(); //join thread
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}