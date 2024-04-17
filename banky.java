import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Account {
    private String name;
    private double balance;

    public Account(String name) {
        this.name = name;
        this.balance = 0.0;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println(amount + " deposited successfully. Current balance: " + balance);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(amount + " withdrawn successfully. Current balance: " + balance);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void transfer(Account recipient, double amount) {
        if (balance >= amount) {
            withdraw(amount);
            recipient.deposit(amount);
            System.out.println(amount + " transferred successfully to " + recipient.getName());
        } else {
            System.out.println("Insufficient funds for transfer.");
        }
    }
}

public class BankY {
    private Map<String, Account> accounts;

    public BankY() {
        accounts = new HashMap<>();
    }

    public void createAccount(String name) {
        if (!accounts.containsKey(name)) {
            Account account = new Account(name);
            accounts.put(name, account);
            System.out.println("Account created successfully for " + name);
        } else {
            System.out.println("Account with name " + name + " already exists.");
        }
    }

    public Account getAccount(String name) {
        return accounts.get(name);
    }

    public static void main(String[] args) {
        BankY bank = new BankY();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Create Account\n2. Deposit\n3. Withdraw\n4. Transfer\n5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter account name: ");
                    String name = scanner.nextLine();
                    bank.createAccount(name);
                    break;
                case 2:
                    System.out.print("Enter account name: ");
                    String depositAccountName = scanner.nextLine();
                    Account depositAccount = bank.getAccount(depositAccountName);
                    if (depositAccount != null) {
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        depositAccount.deposit(depositAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter account name: ");
                    String withdrawAccountName = scanner.nextLine();
                    Account withdrawAccount = bank.getAccount(withdrawAccountName);
                    if (withdrawAccount != null) {
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmount = scanner.nextDouble();
                        withdrawAccount.withdraw(withdrawAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter sender account name: ");
                    String senderName = scanner.nextLine();
                    Account senderAccount = bank.getAccount(senderName);
                    System.out.print("Enter recipient account name: ");
                    String recipientName = scanner.nextLine();
                    Account recipientAccount = bank.getAccount(recipientName);
                    if (senderAccount != null && recipientAccount != null) {
                        System.out.print("Enter transfer amount: ");
                        double transferAmount = scanner.nextDouble();
                        senderAccount.transfer(recipientAccount, transferAmount);
                    } else {
                        System.out.println("One or both accounts not found.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}


/* This Java code defines a simple banking system with classes Account and BankY. Here's a breakdown of the code:

Account Class:

The Account class represents a bank account with attributes name and balance.
It has methods to get the account name, get the balance, deposit money, withdraw money, and transfer money to another account.
BankY Class:

The BankY class manages a collection of accounts using a HashMap<String, Account>.
It has methods to create an account, get an account by name, and contains the main logic for user interactions through the console.
The main method allows users to create accounts, deposit money, withdraw money, transfer money between accounts, and exit the program.
Main Method:

The main method of the BankY class sets up the banking system and provides a console-based interface for users to interact with accounts.
Users can choose options to create an account, deposit money, withdraw money, transfer money, or exit the program.
Overall, this code simulates a basic banking system where users can create accounts, deposit, withdraw, and transfer money between accounts. The program runs in a loop until the user chooses to exit.
*/
