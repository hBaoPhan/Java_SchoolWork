package exercise3.demo;

import exercise3.account.BankAccount;
import exercise3.account.UnsynchronizedBankAccount;
import exercise3.thread.DepositRunnable;
import exercise3.thread.WithdrawRunnable;

public class BankAccountConflictDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Bank Account Conflict Demo (Unsynchronized) ===");
        BankAccount account = new UnsynchronizedBankAccount(0.0);

        final int NUM_THREADS = 5;
        final int REPETITIONS = 1000;
        final double AMOUNT = 100.0;

        Thread[] depositThreads = new Thread[NUM_THREADS];
        Thread[] withdrawThreads = new Thread[NUM_THREADS];

        for (int i = 0; i < NUM_THREADS; i++) {
            depositThreads[i] = new Thread(new DepositRunnable(account, AMOUNT, REPETITIONS, 0),
                    "DepositThread-" + (i + 1));
            withdrawThreads[i] = new Thread(new WithdrawRunnable(account, AMOUNT, REPETITIONS, 0),
                    "WithdrawThread-" + (i + 1));
        }

        System.out.println("Starting " + NUM_THREADS + " deposit threads and " + NUM_THREADS + " withdraw threads...");
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
        if (account.getBalance() != 0.0) {
            System.out.println(">> RACE CONDITION DETECTED! Balance is corrupt due to lack of synchronization.");
        } else {
            System.out.println(">> Balance happened to be 0 (rare in unsynchronized execution).");
        }
    }
}
