package exercise10;

import java.util.Scanner;

public class MVCPatternExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter initial student details:");
        System.out.print("Enter student name: ");
        String initialName = scanner.nextLine();
        System.out.print("Enter student ID: ");
        int initialId = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter student grade: ");
        String initialGrade = scanner.nextLine();

        Student model = new Student(initialName, initialId, initialGrade);
        StudentView view = new StudentView();

        StudentController controller = new StudentController(model, view);

        System.out.println("\nInitial student details:");
        controller.updateView();

        System.out.println("\nEnter new details for the student:");
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter student grade: ");
        String grade = scanner.nextLine();

        controller.setStudentName(name);
        controller.setStudentId(id);
        controller.setStudentGrade(grade);

        System.out.println("\nUpdated student details:");
        controller.updateView();

        scanner.close();
    }
}
