package exercise4;

public class PaypalGateway {
 public void makePayment(double amount) {
     System.out.println("Processing payment of $" + amount + " through PayPal.");
 }
}

class StripeGateway {
 public void charge(double amount) {
     System.out.println("Charging $" + amount + " using Stripe.");
 }
}

class SquareGateway {
 public void pay(double amount) {
     System.out.println("Paying $" + amount + " via Square.");
 }
}
