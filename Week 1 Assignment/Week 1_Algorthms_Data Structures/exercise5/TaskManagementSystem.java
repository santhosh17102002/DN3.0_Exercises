package exercise5;

import java.util.Scanner;

public class TaskManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskLinkedList taskList = new TaskLinkedList();

        while (true) {
            System.out.println("Task Management System");
            System.out.println("1. Add Task");
            System.out.println("2. Search Task");
            System.out.println("3. Traverse Tasks");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Task ID: ");
                    int taskId = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter Task Name: ");
                    String taskName = scanner.nextLine();
                    System.out.print("Enter Task Status: ");
                    String status = scanner.nextLine();
                    taskList.addTask(taskId, taskName, status);
                    break;

                case 2:
                    System.out.print("Enter Task ID to search: ");
                    int searchId = scanner.nextInt();
                    Task task = taskList.searchTask(searchId);
                    if (task != null) {
                        System.out.println("Task found: " + task);
                    } else {
                        System.out.println("Task not found");
                    }
                    break;

                case 3:
                    System.out.println("All Tasks:");
                    taskList.traverseTasks();
                    break;

                case 4:
                    System.out.print("Enter Task ID to delete: ");
                    int deleteId = scanner.nextInt();
                    if (taskList.deleteTask(deleteId)) {
                        System.out.println("Task deleted successfully");
                    } else {
                        System.out.println("Task not found");
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
