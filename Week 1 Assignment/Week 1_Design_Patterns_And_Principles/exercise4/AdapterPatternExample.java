package exercise4;

import java.util.Scanner;

public class AdapterPatternExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PaypalGateway paypalGateway = new PaypalGateway();
        StripeGateway stripeGateway = new StripeGateway();
        SquareGateway squareGateway = new SquareGateway();

        PaymentProcessor paypalAdapter = new PaypalAdapter(paypalGateway);
        PaymentProcessor stripeAdapter = new StripeAdapter(stripeGateway);
        PaymentProcessor squareAdapter = new SquareAdapter(squareGateway);

        System.out.print("Enter amount to process: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); 

        System.out.println("Choose payment gateway: 1. PayPal 2. Stripe 3. Square");
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        switch (choice) {
            case 1:
                paypalAdapter.processPayment(amount);
                break;
            case 2:
                stripeAdapter.processPayment(amount);
                break;
            case 3:
                squareAdapter.processPayment(amount);
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }

        scanner.close();
    }
}
