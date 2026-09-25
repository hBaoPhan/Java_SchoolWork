package exercise3.account;

/**
 * BankAccount implementation using synchronized methods and blocks.
 */
public class SynchronizedBankAccount implements BankAccount {
    private double balance;
    private final Object lock = new Object();
    private final boolean useBlockSynchronization;

    public SynchronizedBankAccount() {
        this(0.0, false);
    }

    public SynchronizedBankAccount(double initialBalance, boolean useBlockSynchronization) {
        this.balance = initialBalance;
        this.useBlockSynchronization = useBlockSynchronization;
    }

    @Override
    public void deposit(double amount) {
        if (useBlockSynchronization) {
            synchronized (lock) {
                double newBalance = balance + amount;
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ignored) {}
                balance = newBalance;
            }
        } else {
            depositMethodSync(amount);
        }
    }

    private synchronized void depositMethodSync(double amount) {
        double newBalance = balance + amount;
        try {
            Thread.sleep(1);
        } catch (InterruptedException ignored) {}
        balance = newBalance;
    }

    @Override
    public void withdraw(double amount) {
        if (useBlockSynchronization) {
            synchronized (lock) {
                double newBalance = balance - amount;
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ignored) {}
                balance = newBalance;
            }
        } else {
            withdrawMethodSync(amount);
        }
    }

    private synchronized void withdrawMethodSync(double amount) {
        double newBalance = balance - amount;
        try {
            Thread.sleep(1);
        } catch (InterruptedException ignored) {}
        balance = newBalance;
    }

    @Override
    public synchronized double getBalance() {
        if (useBlockSynchronization) {
            synchronized (lock) {
                return balance;
            }
        }
        return balance;
    }
}
