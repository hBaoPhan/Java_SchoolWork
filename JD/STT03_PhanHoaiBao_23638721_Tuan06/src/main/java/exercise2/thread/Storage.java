package exercise2.thread;

/**
 * Storage class stores an integer value.
 * Uses wait-notify mechanism to ensure that each number is printed exactly once:
 * - Counter cannot put a new value until Printer has consumed the current one.
 * - Printer cannot read until Counter has produced a new value.
 */
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
