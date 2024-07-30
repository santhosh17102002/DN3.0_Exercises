package exercise1;

import java.util.Scanner;

public class SingletonPatternExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Logger l1 = Logger.getInstance();
        Logger l2 = Logger.getInstance();
        if (l1 == l2) {
            System.out.println("Logger has a single instance.");
        } else {
            System.out.println("Different instances of Logger found.");
        }

        System.out.print("Enter a log message: ");
        String message1 = scanner.nextLine();
        l1.log(message1);

        System.out.print("Enter another log message: ");
        String message2 = scanner.nextLine();
        l2.log(message2);

        scanner.close();
    }
}
