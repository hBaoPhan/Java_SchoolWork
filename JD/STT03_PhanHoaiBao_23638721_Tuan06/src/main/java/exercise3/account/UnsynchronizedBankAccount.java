package exercise3.account;

/**
 * Unsynchronized BankAccount implementation to demonstrate race conditions.
 * Without synchronization, interleaved read-modify-write operations cause balance corruption.
 */
public class UnsynchronizedBankAccount implements BankAccount {
    private double balance;

    public UnsynchronizedBankAccount() {
        this.balance = 0.0;
    }

    public UnsynchronizedBankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public void deposit(double amount) {
        double newBalance = balance + amount;
        try {
            Thread.sleep(1); // Simulate thread preemption/work
        } catch (InterruptedException ignored) {}
        balance = newBalance;
    }

    @Override
    public void withdraw(double amount) {
        double newBalance = balance - amount;
        try {
            Thread.sleep(1); // Simulate thread preemption/work
        } catch (InterruptedException ignored) {}
        balance = newBalance;
    }

    @Override
    public double getBalance() {
        return balance;
    }
}
