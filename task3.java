import java.util.Scanner;

// Class representing a user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        if (initialBalance >= 0)
            this.balance = initialBalance;
        else
            this.balance = 0;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. Amount added: " + amount);
        } else {
            System.out.println("Invalid deposit amount. Must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance. Transaction failed.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. Amount deducted: " + amount);
        }
    }
}

// Class representing the ATM machine
class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        int option;
        do {
            System.out.println("\n====== ATM MENU ======");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");

            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Enter a number (1-4): ");
                scanner.next();
            }

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose 1-4.");
            }

        } while (option != 4);
    }

    private void checkBalance() {
        System.out.println("Your current balance is: " + account.getBalance());
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        account.withdraw(amount);
    }
}

// Main class
public class ATMInterface {
    public static void main(String[] args) {
        // Initial balance can be set here
        BankAccount userAccount = new BankAccount(1000.00); // Starting with $1000
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}
