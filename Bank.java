import java.util.HashMap;

public class Bank {
    private HashMap<Integer, Account> accounts;

    public Bank() {
        accounts = new HashMap<>();
    }

    public void createAccount(int accountNumber, String accountHolderName) {
        if (accounts.containsKey(accountNumber)) {
            System.out.println("Account already exists!");
        } else {
            accounts.put(accountNumber, new Account(accountNumber, accountHolderName));
            System.out.println("Account created successfully!");
        }
    }

    public Account getAccount(int accountNumber) {
        return accounts.get(accountNumber);
    }

    public void removeAccount(int accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            accounts.remove(accountNumber);
            System.out.println("Account removed successfully!");
        } else {
            System.out.println("Account not found!");
        }
    }

    public void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts to display.");
        } else {
            for (Account account : accounts.values()) {
                System.out.println(account);
            }
        }
    }
}

