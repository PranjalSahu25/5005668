package DependencyInjection;
import java.util.Scanner;

public class DependencyInjectionTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create the repository and service objects
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        CustomerService customerService = new CustomerService(customerRepository);

        while (true) {
            System.out.println("Enter customer ID to find (or type 'exit' to quit):");
            String id = scanner.nextLine();

            if (id.equalsIgnoreCase("exit")) {
                break;
            }

            Customer customer = customerService.getCustomerById(id);
            if (customer != null) {
                System.out.println("Customer found: " + customer);
            } else {
                System.out.println("Customer not found.");
            }
        }

        scanner.close();
    }
}
