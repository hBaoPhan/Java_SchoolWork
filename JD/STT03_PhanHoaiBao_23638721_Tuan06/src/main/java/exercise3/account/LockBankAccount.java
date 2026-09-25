package exercise3.account;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockBankAccount implements BankAccount {
    public static final double MAX_BALANCE = 100_000.0;

    private double balance;
    private final Lock balanceChangeLock;
    private final Condition sufficientFundsCondition;
    private final Condition belowLimitCondition;

    public LockBankAccount() {
        this(0.0);
    }

    public LockBankAccount(double initialBalance) {
        this.balance = initialBalance;
        this.balanceChangeLock = new ReentrantLock();
        this.sufficientFundsCondition = balanceChangeLock.newCondition();
        this.belowLimitCondition = balanceChangeLock.newCondition();
    }

    @Override
    public void deposit(double amount) {
        balanceChangeLock.lock();
        try {
            while (balance + amount > MAX_BALANCE) {
                System.out.printf(
                        "[%s] Deposit of $%.2f BLOCKED. Balance ($%.2f) + $%.2f > $%.2f limit. Waiting for withdrawal...%n",
                        Thread.currentThread().getName(), amount, balance, amount, MAX_BALANCE);
                belowLimitCondition.await();
            }
            balance += amount;
            System.out.printf("[%s] Deposited $%.2f, current balance: $%.2f%n",
                    Thread.currentThread().getName(), amount, balance);
            sufficientFundsCondition.signalAll();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            balanceChangeLock.unlock();
        }
    }

    @Override
    public void withdraw(double amount) {
        balanceChangeLock.lock();
        try {
            while (balance < amount) {
                System.out.printf(
                        "[%s] Withdrawal of $%.2f BLOCKED. Insufficient balance ($%.2f). Waiting for deposit...%n",
                        Thread.currentThread().getName(), amount, balance);
                sufficientFundsCondition.await();
            }
            balance -= amount;
            System.out.printf("[%s] Withdrew $%.2f, current balance: $%.2f%n",
                    Thread.currentThread().getName(), amount, balance);
            belowLimitCondition.signalAll();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            balanceChangeLock.unlock();
        }
    }

    @Override
    public double getBalance() {
        balanceChangeLock.lock();
        try {
            return balance;
        } finally {
            balanceChangeLock.unlock();
        }
    }
}
