package SortingCustomerOrders;
import java.util.Scanner;

public class SortingOrders {
    public static void main(String[] args) {
        Order[] orders = {
            new Order("101", "Alice", 250.75),
            new Order("102", "Bob", 120.00),
            new Order("103", "Charlie", 325.50),
            new Order("104", "Dave", 75.20),
            new Order("105", "Eve", 450.90)
        };

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nE-commerce Platform Order Sorting:");
            System.out.println("1. Bubble Sort");
            System.out.println("2. Quick Sort");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    BubbleSort.bubbleSort(orders);
                    System.out.println("Orders sorted by total price using Bubble Sort:");
                    for (Order order : orders) {
                        System.out.println(order);
                    }
                    break;
                case 2:
                    QuickSort.quickSort(orders, 0, orders.length - 1);
                    System.out.println("Orders sorted by total price using Quick Sort:");
                    for (Order order : orders) {
                        System.out.println(order);
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
