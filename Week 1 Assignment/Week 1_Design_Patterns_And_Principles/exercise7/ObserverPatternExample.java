package exercise7;

import java.util.Scanner;

public class ObserverPatternExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StockMarket stockMarket = new StockMarket("TechCorp");
        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        while (true) {
            System.out.println("Stock Market Monitoring System");
            System.out.println("1. Update Stock Price");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 2) {
                break;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter new stock price: ");
                    double newPrice = scanner.nextDouble();
                    stockMarket.setPrice(newPrice);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}
