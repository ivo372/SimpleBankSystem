import java.util.Scanner;

public class Account {
    private int accountNumber;
    private String accountHolderName;
    private int balance;

    public Account(int accountNumber, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = 0; // Initial balance
    }

    // Getters
    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public int getBalance() {
        return balance;
    }

    // Methods
    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. Current balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(int amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. Current balance: " + balance);
        }
    }
     public boolean transfer(Account recipient, int amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds to transfer.");
            return false;
        } else if (amount <= 0) {
            System.out.println("Transfer amount must be positive.");
            return false;
        } else {
            this.balance -= amount;
            recipient.deposit(amount);
            System.out.println("Transfer successful. Your current balance: " + this.balance);
            return true;
        }
    }

    public void checkBalance() {
        System.out.println("Your balance is: " + balance);
    }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber + ", Holder: " + accountHolderName + ", Balance: " + balance;
    }
}
