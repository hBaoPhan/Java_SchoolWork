package exercise2.thread;

public class Storage {
    private int value;
    private boolean hasValue = false;

    public synchronized void setValue(int value) {
        while (hasValue) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        this.value = value;
        this.hasValue = true;
        System.out.println("[Storage] Counter stored: " + value);
        notify();
    }

    public synchronized int getValue() {
        while (!hasValue) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return -1;
            }
        }
        int val = this.value;
        this.hasValue = false;
        System.out.println("[Storage] Printer retrieved: " + val);
        notify();
        return val;
    }
}
