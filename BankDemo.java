package banking;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account = new Account(1001, "Alice", 0.0);

        while (true) {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Show Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter amount to deposit: ");
                        double depositAmt = scanner.nextDouble();
                        account.deposit(depositAmt);
                        break;

                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmt = scanner.nextDouble();
                        account.withdraw(withdrawAmt);
                        break;

                    case 3:
                        account.showBalance();
                        break;

                    case 4:
                        System.out.println("Thank you!");
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice. Please select from 1 to 4.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter numeric values only.");
                scanner.nextLine();

            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());

            } catch (InsufficientBalanceException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
