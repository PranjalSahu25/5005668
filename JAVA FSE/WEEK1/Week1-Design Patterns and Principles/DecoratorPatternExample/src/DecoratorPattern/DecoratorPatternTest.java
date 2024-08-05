package DecoratorPattern;
import java.util.Scanner;

public class DecoratorPatternTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Notifier notifier = new EmailNotifier();

        System.out.println("Do you want to add SMS notification? (yes/no)");
        String smsOption = scanner.nextLine();
        if ("yes".equalsIgnoreCase(smsOption)) {
            notifier = new SMSNotifierDecorator(notifier);
        }

        System.out.println("Do you want to add Slack notification? (yes/no)");
        String slackOption = scanner.nextLine();
        if ("yes".equalsIgnoreCase(slackOption)) {
            notifier = new SlackNotifierDecorator(notifier);
        }

        System.out.println("Enter the message to send:");
        String message = scanner.nextLine();

        notifier.send(message);

        scanner.close();
    }
}

