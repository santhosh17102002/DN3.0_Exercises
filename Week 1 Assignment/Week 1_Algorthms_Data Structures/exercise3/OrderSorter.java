package exercise3;

import java.util.Scanner;

public class OrderSorter {

    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    // Swap orders[j] and orders[j + 1]
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);

            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() <= pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of orders:");
        int numOfOrders = scanner.nextInt();
        scanner.nextLine();  

        Order[] orders = new Order[numOfOrders];

        for (int i = 0; i < numOfOrders; i++) {
            System.out.println("Enter details for order " + (i + 1) + ":");
            System.out.print("Order ID: ");
            String orderId = scanner.nextLine();
            System.out.print("Customer Name: ");
            String customerName = scanner.nextLine();
            System.out.print("Total Price: ");
            double totalPrice = scanner.nextDouble();
            scanner.nextLine();  

            orders[i] = new Order(orderId, customerName, totalPrice);
        }

        System.out.println("Choose a sorting algorithm:");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Quick Sort");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                bubbleSort(orders);
                break;
            case 2:
                quickSort(orders, 0, orders.length - 1);
                break;
            default:
                System.out.println("Invalid choice.");
                scanner.close();
                return;
        }

        System.out.println("Sorted orders by total price:");
        for (Order order : orders) {
            System.out.println(order);
        }

        scanner.close();
    }
}
