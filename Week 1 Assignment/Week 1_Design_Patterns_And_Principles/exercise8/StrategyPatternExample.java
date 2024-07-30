package exercise8;

import java.util.Scanner;

public class StrategyPatternExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a payment method:");
        System.out.println("1. Credit Card");
        System.out.println("2. PayPal");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        PaymentContext paymentContext;

        switch (choice) {
            case 1:
                System.out.print("Enter Credit Card Number: ");
                String cardNumber = scanner.next();
                System.out.print("Enter Card Holder Name: ");
                String name = scanner.next();
                paymentContext = new PaymentContext(new CreditCardPayment(cardNumber, name));
                break;
            case 2:
                System.out.print("Enter PayPal Email: ");
                String email = scanner.next();
                paymentContext = new PaymentContext(new PayPalPayment(email));
                break;
            default:
                System.out.println("Invalid choice.");
                scanner.close();
                return;
        }

        System.out.print("Enter amount to pay: ");
        double amount = scanner.nextDouble();
        paymentContext.executePayment(amount);

        scanner.close();
    }
}
