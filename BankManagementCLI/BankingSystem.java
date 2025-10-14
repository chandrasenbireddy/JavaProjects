

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankingSystem {
    private static Map<Integer, Account> accounts = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Banking System Menu ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
    private static void createAccount() {
        System.out.println("\n--- Create Account ---");
        System.out.print("Enter Account Number: ");
        int accNum = sc.nextInt();
        sc.nextLine(); // Consume newline
        System.out.print("Enter Account Holder Name: ");
        String accHolder = sc.nextLine();
        System.out.print("Enter Initial Deposit: ");
        double initialDeposit = sc.nextDouble();
        Account newAccount = new Account(accNum, accHolder, initialDeposit);
        accounts.put(accNum, newAccount);
        System.out.println("Account created successfully!");
    }
    private static void deposit() {
        System.out.println("\n--- Deposit ---");
        System.out.print("Enter Account Number: ");
        int accNum = sc.nextInt();
        sc.nextLine(); // Consume newline
        Account account = accounts.get(accNum);
        if (account == null) {
            System.out.println("Account not found.");
            return;
        }
        System.out.print("Enter Deposit Amount: ");
        double amount = sc.nextDouble();
        sc.nextLine(); // Consume newline
        try {account.deposit(amount);}
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Deposit successful!" + " New Balance: " + account.getBalance());
    }
    private static void withdraw() {
        System.out.println("\n--- Withdraw ---");
        System.out.print("Enter Account Number: ");
        int accNum = sc.nextInt();
        sc.nextLine(); // Consume newline
        Account account = accounts.get(accNum);
        if(account == null) {
            System.out.println("Account not found.");
            return;
        }
        System.out.print("Enter Withdrawal Amount: ");
        double amount = sc.nextDouble();
        sc.nextLine(); // Consume newline
        try {
            account.withdraw(amount);
            System.out.println("Withdrawal successful!");
        }
        catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
    private static void checkBalance() {
        System.out.println("\n--- Check Balance ---");
        System.out.print("Enter Account Number: ");
        int accNum = sc.nextInt();
        sc.nextLine(); // Consume newline
        Account account = accounts.get(accNum);
        if(account == null) {
            System.out.println("Account not found.");
            return;
        }
        account.getBalanceInfo();
    }
}
