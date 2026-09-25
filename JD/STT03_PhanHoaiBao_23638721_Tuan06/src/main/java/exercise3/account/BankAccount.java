package exercise3.account;

/**
 * Common interface for Bank Account implementations.
 */
public interface BankAccount {
    void deposit(double amount);
    void withdraw(double amount);
    double getBalance();
}
