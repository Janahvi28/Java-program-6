package banking;

public class Account {
    private int accountNo;
    private String name;
    private double balance;

    public Account(int accountNo, String name, double balance) {
        this.accountNo = accountNo;
        this.name = name;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount < 0) {
            throw new ArithmeticException("Cannot deposit a negative amount.");
        }
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount < 0) {
            throw new ArithmeticException("Cannot withdraw a negative amount.");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance. You have only: " + balance);
        }
        balance -= amount;
        System.out.println("Withdrawn: " + amount);
    }

    public void showBalance() {
        System.out.println("Account No: " + accountNo);
        System.out.println("Name: " + name);
        System.out.println("Current Balance: " + balance);
    }
}
