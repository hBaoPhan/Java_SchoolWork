package exercise3.thread;

import exercise3.account.BankAccount;

/**
 * Task that repeatedly withdraws money from a BankAccount.
 */
public class WithdrawRunnable implements Runnable {
    private final BankAccount account;
    private final double amount;
    private final int count;
    private final long delayMs;

    public WithdrawRunnable(BankAccount account, double amount, int count) {
        this(account, amount, count, 2);
    }

    public WithdrawRunnable(BankAccount account, double amount, int count, long delayMs) {
        this.account = account;
        this.amount = amount;
        this.count = count;
        this.delayMs = delayMs;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < count; i++) {
                account.withdraw(amount);
                if (delayMs > 0) {
                    Thread.sleep(delayMs);
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
