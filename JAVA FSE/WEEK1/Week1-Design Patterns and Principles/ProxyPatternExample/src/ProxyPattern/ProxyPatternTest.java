package ProxyPattern;
import java.util.Scanner;

public class ProxyPatternTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of images you want to load: ");
        int numberOfImages = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Image[] images = new ProxyImage[numberOfImages];

        // Get image filenames from user
        for (int i = 0; i < numberOfImages; i++) {
            System.out.print("Enter filename for image " + (i + 1) + ": ");
            String filename = scanner.nextLine();
            images[i] = new ProxyImage(filename);
        }

        // Display images
        for (Image image : images) {
            image.display();
            System.out.println("");
        }

        scanner.close();
    }
}
