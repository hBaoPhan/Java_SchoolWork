package exercise1.thread;

public class PrintNumbersTask implements Runnable {
    private final String taskName;

    public PrintNumbersTask(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(taskName + " - Count: " + i);
            try {
                Thread.sleep(100); // Tạm dừng 100ms để dễ quan sát tiến trình
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println(taskName + " bị gián đoạn.");
                break;
            }
        }
    }
}