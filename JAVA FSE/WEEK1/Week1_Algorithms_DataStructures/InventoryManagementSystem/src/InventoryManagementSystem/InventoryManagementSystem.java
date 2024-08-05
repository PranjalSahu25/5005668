package InventoryManagementSystem;

import java.util.HashMap;
import java.util.Scanner;

public class InventoryManagementSystem {
    private HashMap<String, Product> inventory;

    public InventoryManagementSystem() {
        inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }

    public void updateProduct(Product product) {
        if (inventory.containsKey(product.getProductId())) {
            inventory.put(product.getProductId(), product);
        } else {
            System.out.println("Product not found in inventory.");
        }
    }

    public void deleteProduct(String productId) {
        if (inventory.containsKey(productId)) {
            inventory.remove(productId);
        } else {
            System.out.println("Product not found in inventory.");
        }
    }

    public Product getProduct(String productId) {
        return inventory.get(productId);
    }

    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nInventory Management System:");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. View Product");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    String addId = scanner.nextLine();
                    System.out.print("Enter Product Name: ");
                    String addName = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    int addQuantity = scanner.nextInt();
                    System.out.print("Enter Price: ");
                    double addPrice = scanner.nextDouble();
                    ims.addProduct(new Product(addId, addName, addQuantity, addPrice));
                    System.out.println("Product added.");
                    break;
                case 2:
                    System.out.print("Enter Product ID to update: ");
                    String updateId = scanner.nextLine();
                    if (ims.getProduct(updateId) != null) {
                        System.out.print("Enter New Product Name: ");
                        String updateName = scanner.nextLine();
                        System.out.print("Enter New Quantity: ");
                        int updateQuantity = scanner.nextInt();
                        System.out.print("Enter New Price: ");
                        double updatePrice = scanner.nextDouble();
                        ims.updateProduct(new Product(updateId, updateName, updateQuantity, updatePrice));
                        System.out.println("Product updated.");
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter Product ID to delete: ");
                    String deleteId = scanner.nextLine();
                    ims.deleteProduct(deleteId);
                    System.out.println("Product deleted.");
                    break;
                case 4:
                    System.out.print("Enter Product ID to view: ");
                    String viewId = scanner.nextLine();
                    Product product = ims.getProduct(viewId);
                    if (product != null) {
                        System.out.println(product);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
