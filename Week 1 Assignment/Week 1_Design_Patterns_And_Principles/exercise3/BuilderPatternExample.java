package exercise3;

import java.util.Scanner;

public class BuilderPatternExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Computer.Builder builder = new Computer.Builder();

        System.out.print("Enter CPU: ");
        String CPU = scanner.nextLine();
        builder.setCPU(CPU);

        System.out.print("Enter RAM: ");
        String RAM = scanner.nextLine();
        builder.setRAM(RAM);

        System.out.print("Enter Storage: ");
        String storage = scanner.nextLine();
        builder.setStorage(storage);

        System.out.print("Enter GPU: ");
        String GPU = scanner.nextLine();
        builder.setGPU(GPU);

        System.out.print("Enter Motherboard: ");
        String motherboard = scanner.nextLine();
        builder.setMotherboard(motherboard);

        System.out.print("Enter Power Supply: ");
        String powerSupply = scanner.nextLine();
        builder.setPowerSupply(powerSupply);

        System.out.print("Enter Cooling System: ");
        String coolingSystem = scanner.nextLine();
        builder.setCoolingSystem(coolingSystem);
        Computer computer = builder.build();

        System.out.println("\nCreated Computer configuration:");
        System.out.println(computer);

        scanner.close();
    }
}

