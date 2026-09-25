package exercise2.thread;

/**
 * Counter thread starts counting from 0 (0, 1, 2, 3...)
 * and stores each value in the Storage instance.
 */
public class Counter implements Runnable {
    private final Storage storage;
    private final int limit;

    public Counter(Storage storage, int limit) {
        this.storage = storage;
        this.limit = limit;
    }

    @Override
    public void run() {
        for (int i = 0; i <= limit; i++) {
            storage.setValue(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        System.out.println("Counter completed counting to " + limit);
    }
}
