package EcommercePlatformSearchFunction;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SearchFunction {
    public static void main(String[] args) {
        Product[] products = {
            new Product("101", "Laptop", "Electronics"),
            new Product("102", "Smartphone", "Electronics"),
            new Product("103", "Tablet", "Electronics"),
            new Product("104", "Headphones", "Accessories"),
            new Product("105", "Charger", "Accessories")
        };

        // Sort the array based on productId for binary search
        Arrays.sort(products, Comparator.comparing(Product::getProductId));

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nE-commerce Platform Search Function:");
            System.out.println("1. Linear Search");
            System.out.println("2. Binary Search");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID to search: ");
                    String linearTargetId = scanner.nextLine();
                    Product linearResult = LinearSearch.linearSearch(products, linearTargetId);
                    if (linearResult != null) {
                        System.out.println("Product found: " + linearResult);
                    } else {
                        System.out.println("Product not found");
                    }
                    break;
                case 2:
                    System.out.print("Enter Product ID to search: ");
                    String binaryTargetId = scanner.nextLine();
                    Product binaryResult = BinarySearch.binarySearch(products, binaryTargetId);
                    if (binaryResult != null) {
                        System.out.println("Product found: " + binaryResult);
                    } else {
                        System.out.println("Product not found");
                    }
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}

