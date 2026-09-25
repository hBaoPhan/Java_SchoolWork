package exercise3.demo;

import exercise3.account.BankAccount;
import exercise3.account.SynchronizedBankAccount;
import exercise3.thread.DepositRunnable;
import exercise3.thread.WithdrawRunnable;

public class BankAccountSynchronizedDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Testing Method Synchronization ===");
        testSynchronization(false);

        System.out.println("\n=== Testing Block Synchronization ===");
        testSynchronization(true);
    }

    private static void testSynchronization(boolean useBlockSync) throws InterruptedException {
        BankAccount account = new SynchronizedBankAccount(0.0, useBlockSync);
        final int NUM_THREADS = 5;
        final int REPETITIONS = 1000;
        final double AMOUNT = 100.0;

        Thread[] depositThreads = new Thread[NUM_THREADS];
        Thread[] withdrawThreads = new Thread[NUM_THREADS];

        for (int i = 0; i < NUM_THREADS; i++) {
            depositThreads[i] = new Thread(new DepositRunnable(account, AMOUNT, REPETITIONS, 0),
                    "SyncDeposit-" + (i + 1));
            withdrawThreads[i] = new Thread(new WithdrawRunnable(account, AMOUNT, REPETITIONS, 0),
                    "SyncWithdraw-" + (i + 1));
        }

        for (int i = 0; i < NUM_THREADS; i++) {
            depositThreads[i].start();
            withdrawThreads[i].start();
        }

        for (int i = 0; i < NUM_THREADS; i++) {
            depositThreads[i].join();
            withdrawThreads[i].join();
        }

        System.out.println("Expected final balance: $0.0");
        System.out.println("Actual final balance:   $" + account.getBalance());
        System.out.println("Result: " + (account.getBalance() == 0.0 ? "SUCCESS! Thread-safe." : "FAILED!"));
    }
}
