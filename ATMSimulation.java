import java.util.Scanner;

// Step 4: BankAccount class
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✅ Successfully deposited: ₹" + amount);
        } else {
            System.out.println("❌ Invalid deposit amount!");
        }
    }

    // Withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("✅ Successfully withdrawn: ₹" + amount);
        } else if (amount > balance) {
            System.out.println("❌ Insufficient balance!");
        } else {
            System.out.println("❌ Invalid withdrawal amount!");
        }
    }

    // Check balance
    public double getBalance() {
        return balance;
    }
}

// Step 1 & 2: ATM class
class ATM {
    private BankAccount account;
    private Scanner sc;

    public ATM(BankAccount account) {
        this.account = account;
        this.sc = new Scanner(System.in);
    }

    // Display ATM menu
    public void showMenu() {
        int choice;
        do {
            System.out.println("\n===== ATM Menu =====");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> performWithdraw();
                case 2 -> performDeposit();
                case 3 -> System.out.println("💰 Current Balance: ₹" + account.getBalance());
                case 4 -> System.out.println("👋 Thank you for using the ATM!");
                default -> System.out.println("❌ Invalid choice! Please try again.");
            }
        } while (choice != 4);
    }

    // Step 3: Withdraw method
    private void performWithdraw() {
        System.out.print("Enter amount to withdraw: ₹");
        double amount = sc.nextDouble();
        account.withdraw(amount);
    }

    // Step 3: Deposit method
    private void performDeposit() {
        System.out.print("Enter amount to deposit: ₹");
        double amount = sc.nextDouble();
        account.deposit(amount);
    }
}

// Step 5: Main class to run program
public class ATMSimulation {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(5000.00); // initial balance ₹5000
        ATM atm = new ATM(userAccount);
        atm.showMenu();  // Start ATM menu
    }
}
