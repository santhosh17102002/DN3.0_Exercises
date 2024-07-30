package exercise9;

import java.util.Scanner;

public class CommandPatternExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Light light = new Light();
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);
        RemoteControl remoteControl = new RemoteControl();

        System.out.println("Home Automation System");
        System.out.println("1. Turn Light On");
        System.out.println("2. Turn Light Off");
        System.out.println("3. Exit");
        while (true) {
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 3) {
                break;
            }

            switch (choice) {
                case 1:
                    remoteControl.setCommand(lightOn);
                    remoteControl.pressButton();
                    break;
                case 2:
                    remoteControl.setCommand(lightOff);
                    remoteControl.pressButton();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}
