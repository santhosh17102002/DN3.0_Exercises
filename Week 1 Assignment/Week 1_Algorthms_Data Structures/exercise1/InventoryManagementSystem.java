package exercise1;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InventoryManagementSystem {
    private Map<String, Product> inventory;

    
    public InventoryManagementSystem() {
        inventory = new HashMap<>();
    }
    
    public void displayProducts() {
        for (Product product : inventory.values()) {
            System.out.println("ID: " + product.getProductId() + ", Name: " + product.getProductName() +
                    ", Quantity: " + product.getQuantity() + ", Price: " + product.getPrice());
        }
    }
    
    
    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }
    
    
    public void updateProduct(String productId, int quantity, double price) {
        Product product = inventory.get(productId);
        if (product != null) {
            product.setQuantity(quantity);
            product.setPrice(price);
        } else {
            System.out.println("Product not found.");
        }
    }
    
    
    public void deleteProduct(String productId) {
        inventory.remove(productId);
    }
    
      
    

    public static void main(String[] args) {    	
    	
        InventoryManagementSystem ims = new InventoryManagementSystem();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Choose an option: ");
        System.out.println("1. Add Product");
        System.out.println("2. Update Product");
        System.out.println("3. Delete Product");
        System.out.println("4. Display Products");
        System.out.println("5. Exit");
        
        while (true) {            
            System.out.println("Enter your option : ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.println("Enter Product ID: ");
                    String productId = scanner.nextLine();
                    System.out.println("Enter Product Name: ");
                    String productName = scanner.nextLine();
                    System.out.println("Enter Quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.println("Enter Price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();  
                    
                    Product newProduct = new Product(productId, productName, quantity, price);
                    ims.addProduct(newProduct);
                    break;
                
                case 2:
                    System.out.println("Enter Product ID to update: ");
                    String updateProductId = scanner.nextLine();
                    System.out.println("Enter new Quantity: ");
                    int newQuantity = scanner.nextInt();
                    System.out.println("Enter new Price: ");
                    double newPrice = scanner.nextDouble();
                    scanner.nextLine();
                    
                    ims.updateProduct(updateProductId, newQuantity, newPrice);
                    break;
                
                case 3:
                    System.out.println("Enter Product ID to delete: ");
                    String deleteProductId = scanner.nextLine();
                    ims.deleteProduct(deleteProductId);
                    break;
                
                case 4:
                    ims.displayProducts();
                    break;
                
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
