package CommandPattern;
import java.util.Scanner;

public class CommandPatternTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Light light = new Light();

        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);
        RemoteControl remote = new RemoteControl();

        while (true) {
            System.out.print("Enter command (1. Turn ON, 2. Turn OFF, 3. Exit): ");
            int choice = scanner.nextInt();

            if (choice == 3) {
                System.out.println("Exiting...");
                break;
            }

            switch (choice) {
                case 1:
                    remote.setCommand(lightOn);
                    remote.pressButton();
                    break;
                case 2:
                    remote.setCommand(lightOff);
                    remote.pressButton();
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }

        scanner.close();
    }
}
