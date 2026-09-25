package exercise3.demo;

import exercise3.account.LockBankAccount;
import exercise3.thread.DepositRunnable;
import exercise3.thread.WithdrawRunnable;

public class BankAccountLockConditionDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Bank Account Lock & Condition Demo ($100,000 Limit) ===");
        LockBankAccount account = new LockBankAccount(90000.0);
        System.out.printf("Initial balance: $%.2f (Limit: $%.2f)%n", account.getBalance(), LockBankAccount.MAX_BALANCE);

        // We create 15 deposit threads each depositing $2,000 (Total intended deposits
        // = $30,000)
        // Since initial is $90,000, after 5 deposits ($10,000), balance reaches
        // $100,000.
        // Subsequent deposits will BLOCK waiting for withdrawals!
        int numDeposits = 15;
        Thread[] depositThreads = new Thread[numDeposits];
        for (int i = 0; i < numDeposits; i++) {
            depositThreads[i] = new Thread(new DepositRunnable(account, 2000.0, 1, 10), "DepositThread-" + (i + 1));
        }

        // We start deposit threads
        System.out.println("\nStarting deposit threads...");
        for (Thread t : depositThreads) {
            t.start();
        }

        // Sleep briefly to let deposits reach the $100,000 cap and block
        Thread.sleep(300);
        System.out.printf("%n[Notice] Current balance reached: $%.2f. Additional deposits should now be BLOCKED.%n%n",
                account.getBalance());

        // Now start 3 withdrawal threads each withdrawing $5,000, to unblock the
        // waiting deposit threads
        int numWithdrawals = 4;
        Thread[] withdrawThreads = new Thread[numWithdrawals];
        for (int i = 0; i < numWithdrawals; i++) {
            withdrawThreads[i] = new Thread(new WithdrawRunnable(account, 5000.0, 1, 150), "WithdrawThread-" + (i + 1));
        }

        System.out.println("Starting withdrawal threads to free up space below $100,000 limit...");
        for (Thread t : withdrawThreads) {
            t.start();
        }

        // Wait for all threads to finish
        for (Thread t : depositThreads) {
            t.join();
        }
        for (Thread t : withdrawThreads) {
            t.join();
        }

        System.out.printf("%n=== All operations completed. Final balance: $%.2f ===%n", account.getBalance());
    }
}
