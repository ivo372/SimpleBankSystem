import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1 - Create Account");
            System.out.println("2 - Access Account");
            System.out.println("3 - Remove Account");
            System.out.println("4 - Display All Accounts");
            System.out.println("5 - Exit");
            System.out.print("Option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Enter account number: ");
                    int newAccountNumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter account holder name: ");
                    String name = scanner.nextLine();
                    bank.createAccount(newAccountNumber, name);
                    break;

                case 2:
                    System.out.print("Enter your account number: ");
                    int accountNumber = scanner.nextInt();
                    Account account = bank.getAccount(accountNumber);

                    if (account != null) {
                        System.out.println("Welcome, " + account.getAccountHolderName() + "!");
                        boolean sessionActive = true;

                        while (sessionActive) {
                            System.out.println("1 - Deposit\n2 - Withdraw\n3 - Check Balance\n4 - Transfer\n5 - Logout");
                            System.out.print("Choose an option: ");
                            int choice = scanner.nextInt();

                            switch (choice) {
                                case 1:
                                    System.out.print("Enter amount to deposit: ");
                                    int deposit = scanner.nextInt();
                                    account.deposit(deposit);
                                    break;
                                case 2:
                                    System.out.print("Enter amount to withdraw: ");
                                    int withdraw = scanner.nextInt();
                                    account.withdraw(withdraw);
                                    break;
                                case 3:
                                    account.checkBalance();
                                    break;
                                case 4:
                                    System.out.print("Enter recipient account number: ");
                                    int recipientAccountNumber = scanner.nextInt();
                                    Account recipient = bank.getAccount(recipientAccountNumber);

                                    if (recipient != null) {
                                        if (recipientAccountNumber == account.getAccountNumber()) {
                                            System.out.println("Cannot transfer to the same account.");
                                            break;
                                        }
                                        System.out.print("Enter amount to transfer: ");
                                        int transferAmount = scanner.nextInt();
                                        account.transfer(recipient, transferAmount);
                                    } else {
                                        System.out.println("Recipient account not found.");
                                    }
                                    break;
                                case 5:
                                    sessionActive = false;
                                    break;
                                default:
                                    System.out.println("Invalid option.");
                            }
                        }
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter account number to remove: ");
                    int removeAccountNumber = scanner.nextInt();
                    bank.removeAccount(removeAccountNumber);
                    break;

                case 4:
                    bank.displayAllAccounts();
                    break;

                case 5:
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option, try again.");
            }
        }
    }
}
