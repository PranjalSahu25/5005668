package StrategyPattern;
import java.util.Scanner;

public class StrategyPatternTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PaymentContext paymentContext = new PaymentContext();

        while (true) {
            System.out.print("Select payment method (1. Credit Card, 2. PayPal, 3. Exit): ");
            int choice = scanner.nextInt();

            if (choice == 3) {
                System.out.println("Exiting...");
                break;
            }

            System.out.print("Enter amount to pay: ");
            double amount = scanner.nextDouble();

            switch (choice) {
                case 1:
                    System.out.print("Enter Credit Card number: ");
                    String cardNumber = scanner.next();
                    paymentContext.setPaymentStrategy(new CreditCardPayment(cardNumber));
                    paymentContext.executePayment(amount);
                    break;
                case 2:
                    System.out.print("Enter PayPal email: ");
                    String email = scanner.next();
                    paymentContext.setPaymentStrategy(new PayPalPayment(email));
                    paymentContext.executePayment(amount);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
