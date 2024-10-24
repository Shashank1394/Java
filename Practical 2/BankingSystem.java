// Write a program in Java program using constructor to create a simple banking application. The program should allow users to create multiple bank accounts, each with a unique account number, name of the account holder, and initial balance. Users should be able to perform operations such as deposit, withdrawal, and balance inquiry on their accounts. Provide a menu-driven interface for users to interact with the banking application.

import java.util.Random;
import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(String accountHolderName, double initialBalance) {
        this.accountNumber = generateAccountNumber();
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    private String generateAccountNumber() {
        Random random = new Random();
        StringBuilder accountNumber = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int digit = random.nextInt(10);
            accountNumber.append(digit);
        }
        return accountNumber.toString();
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }

    public void checkBalance() {
        System.out.println("Account balance: $" + balance);
    }

    public String getAccountInfo() {
        return "Account Number: " + accountNumber + ", Account Holder: " + accountHolderName + ", Balance: $" + balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount[] accounts = new BankAccount[100];
        int accountCount = 0;

        while (true) {
            System.out.println("\n--- Banking Application Menu ---");
            System.out.println("1. Create New Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Account Info");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter account holder's name: ");
                    String accountHolderName = sc.nextLine();
                    System.out.print("Enter initial balance: $");
                    double initialBalance = sc.nextDouble();
                    accounts[accountCount] = new BankAccount(accountHolderName, initialBalance);
                    System.out.println("Account created successfully.");
                    System.out.println("Account Number: " + accounts[accountCount].getAccountNumber());
                    accountCount++;
                    break;

                case 2:
                    System.out.print("Enter account number: ");
                    String accountNumber = sc.nextLine();
                    BankAccount depositAccount = findAccount(accounts, accountCount, accountNumber);
                    if (depositAccount != null) {
                        System.out.print("Enter deposit amount: $");
                        double depositAmount = sc.nextDouble();
                        depositAccount.deposit(depositAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter account number: ");
                    accountNumber = sc.nextLine();
                    BankAccount withdrawAccount = findAccount(accounts, accountCount, accountNumber);
                    if (withdrawAccount != null) {
                        System.out.print("Enter withdrawal amount: $");
                        double withdrawAmount = sc.nextDouble();
                        withdrawAccount.withdraw(withdrawAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter account number: ");
                    accountNumber = sc.nextLine();
                    BankAccount balanceAccount = findAccount(accounts, accountCount, accountNumber);
                    if (balanceAccount != null) {
                        balanceAccount.checkBalance();
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter account number: ");
                    accountNumber = sc.nextLine();
                    BankAccount infoAccount = findAccount(accounts, accountCount, accountNumber);
                    if (infoAccount != null) {
                        System.out.println(infoAccount.getAccountInfo());
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 6:
                    System.out.println("Exiting application.");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static BankAccount findAccount(BankAccount[] accounts, int accountCount, String accountNumber) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber().equals(accountNumber)) {
                return accounts[i];
            }
        }
        return null;
    }
}
