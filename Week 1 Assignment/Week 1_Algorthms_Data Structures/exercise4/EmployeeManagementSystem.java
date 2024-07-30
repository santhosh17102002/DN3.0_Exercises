package exercise4;

import java.util.Scanner;

public class EmployeeManagementSystem {
    private Employee[] employees;
    private int size;

    public EmployeeManagementSystem(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    public void addEmployee(Employee employee) {
        if (size < employees.length) {
            employees[size++] = employee;
        } else {
            System.out.println("Array is full. Cannot add more employees.");
        }
    }
    public Employee searchEmployee(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                return employees[i];
            }
        }
        return null;
    }

    public void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public void deleteEmployee(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                employees[i] = employees[size - 1]; 
                employees[size - 1] = null;
                size--;
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the capacity of the employee management system:");
        int capacity = scanner.nextInt();
        scanner.nextLine();  

        EmployeeManagementSystem ems = new EmployeeManagementSystem(capacity);

        System.out.println("Choose an option:");
        System.out.println("1. Add Employee");
        System.out.println("2. Search Employee");
        System.out.println("3. Traverse Employees");
        System.out.println("4. Delete Employee");
        System.out.println("5. Exit");

        while (true) {

            System.out.print("Enter your option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    String employeeId = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Position: ");
                    String position = scanner.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = scanner.nextDouble();
                    scanner.nextLine();  

                    Employee employee = new Employee(employeeId, name, position, salary);
                    ems.addEmployee(employee);
                    break;
                case 2:
                    System.out.print("Enter Employee ID to search: ");
                    String searchId = scanner.nextLine();
                    Employee foundEmployee = ems.searchEmployee(searchId);
                    if (foundEmployee != null) {
                        System.out.println("Employee found: " + foundEmployee);
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;
                case 3:
                    ems.traverseEmployees();
                    break;
                case 4:
                    System.out.print("Enter Employee ID to delete: ");
                    String deleteId = scanner.nextLine();
                    ems.deleteEmployee(deleteId);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
