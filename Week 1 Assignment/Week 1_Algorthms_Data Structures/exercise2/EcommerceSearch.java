package exercise2;

import java.util.Arrays;
import java.util.Scanner;

public class EcommerceSearch {
    private Product[] products;

    public EcommerceSearch(Product[] products) {
        this.products = products;
    }

    public Product linearSearch(String productName) {
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(productName)) {
                return product;
            }
        }
        return null;
    }

    public Product binarySearch(String productName) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].getProductName().compareToIgnoreCase(productName);

            if (comparison == 0) {
                return products[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of products:");
        int numOfProducts = scanner.nextInt();
        scanner.nextLine();  

        Product[] products = new Product[numOfProducts];

        for (int i = 0; i < numOfProducts; i++) {
            System.out.println("Enter details for product " + (i + 1) + ":");
            System.out.print("Product ID: ");
            String productId = scanner.nextLine();
            System.out.print("Product Name: ");
            String productName = scanner.nextLine();
            System.out.print("Category: ");
            String category = scanner.nextLine();

            products[i] = new Product(productId, productName, category);
        }
        Arrays.sort(products, (p1, p2) -> p1.getProductName().compareToIgnoreCase(p2.getProductName()));

        EcommerceSearch search = new EcommerceSearch(products);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Linear Search");
            System.out.println("2. Binary Search");
            System.out.println("3. Exit");

            System.out.print("Enter your option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  

            if (choice == 3) {
                System.out.println("Exiting...");
                break;
            }

            System.out.print("Enter product name to search: ");
            String productName = scanner.nextLine();

            Product result = null;

            switch (choice) {
                case 1:
                    result = search.linearSearch(productName);
                    break;
                case 2:
                    result = search.binarySearch(productName);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    continue;
            }

            if (result != null) {
                System.out.println("Product found: " + result);
            } else {
                System.out.println("Product not found.");
            }
        }

        scanner.close();
    }
}
