package thread;

import java.util.concurrent.Callable;

public class PrimeCheckTask implements Callable<Boolean> {
    private final long number;

    public PrimeCheckTask(long number) {
        this.number = number;
    }

    @Override
    public Boolean call() {
        if (number <= 1) {
            return false;
        }
        for (long i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}