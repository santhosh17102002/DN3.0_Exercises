package exercise5;
import java.util.Scanner;

public class DecoratorPatternExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Notifier emailNotifier = new EmailNotifier();

        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);
        Notifier slackNotifier = new SlackNotifierDecorator(emailNotifier);

        System.out.println("Notification System");
        System.out.println("1. Send Email");
        System.out.println("2. Send Email and SMS");
        System.out.println("3. Send Email and Slack");
        System.out.println("4. Send Email, SMS, and Slack");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter the message: ");
        
        String message = scanner.nextLine();

        switch (choice) {
            case 1:
                emailNotifier.send(message);
                break;
            case 2:
                smsNotifier.send(message);
                break;
            case 3:
                slackNotifier.send(message);
                break;
            case 4:
                Notifier combinedNotifier = new SlackNotifierDecorator(smsNotifier);
                combinedNotifier.send(message);
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }

        scanner.close();
    }
}
