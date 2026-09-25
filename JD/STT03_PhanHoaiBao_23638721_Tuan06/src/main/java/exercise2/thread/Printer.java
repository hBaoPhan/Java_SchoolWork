package exercise2.thread;

public class Printer implements Runnable {
    private final Storage storage;
    private final int count;

    public Printer(Storage storage, int count) {
        this.storage = storage;
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i <= count; i++) {
            int value = storage.getValue();
            System.out.println("==> [Printer Output] Number: " + value);
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        System.out.println("Printer finished printing " + (count + 1) + " numbers.");
    }
}
